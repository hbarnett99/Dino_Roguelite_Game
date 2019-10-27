package game;



import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;

/**
 * Behaviour for herbivorous dinosaurs to actively seek a given target; ground or an item
 */
public class SeekBehaviour implements Behaviour {
	private Random random = new Random();
	private Location target = null;
	private String food;
	private String food2;
	private Item foodItem;
	private Item foodItem2;
	private Item foodMisc;
	private Boolean isGround = false;
	
	/**
	 * 
	 * @param foodSource main ground food source
	 * @param itemFood	item food source
	 * @param secondaryfoodSource	secondary ground food source
	 * @param secondaryitemFood	secondary item food source
	 * @param miscFood	miscellaneous item food source, useful if I need to extend seekBehaviour
	 */
	public SeekBehaviour(String foodSource, Item itemFood, String secondaryfoodSource,Item secondaryitemFood,Item miscFood) {
				
		food = foodSource;
		food2 = secondaryfoodSource;
		foodItem = itemFood;
		foodItem2 = secondaryitemFood;
		foodMisc = miscFood;
		
		//this.target = subject;
	}
/**
 * multiple constructors again to allow multiple herbivorous dinos to use
 * @param foodSource	The source of food
 * @param herbivoreFood	The Herbivore item
 */
	public SeekBehaviour(String foodSource, HerbivoreFood herbivoreFood) {
		food = foodSource;
		foodItem = herbivoreFood;
	}
	public SeekBehaviour(String foodSource, CarnivoreFood herbivoreFood) {
		food = foodSource;
		foodItem = herbivoreFood;
	}


	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<Action>();
		if(!map.contains(actor))
		return null;
		/**
		 * @param minX actors location x - 5
		 * @param minY 
		 * @param maxX
		 * @param maxY
		 */
		Location here = map.locationOf(actor);
		int minX;
		int minY;
		int maxX;
		int maxY;
		/*
		 * Sets the values of the variables above to a 5x5 grid around the Dino
		 */
		//x min
		if (here.x()-5 <= map.getXRange().min()) {minX =  map.getXRange().min();}
		else {minX = here.x()-5;}
		//y min
		if (here.y()-5 <= map.getYRange().min()) {minY =  map.getYRange().min();}
		else {minY = here.y()-5;}
		//xMax
		if (here.x()-5 <= map.getXRange().max()) {maxX = map.getXRange().max();}
		else {maxX = here.x()+5;}
		//maxY
		if (here.x()-5 <= map.getYRange().max()) {maxY = map.getYRange().max();}
		else {maxY = here.y()+5;}
		/*
		 * Searches in a 5x5 block for a target
		 */
		outerloop:
			for (int i = minX; i < maxX; i++) {
				for (int k = minY; k < maxY; k++) {
					//checks the 
					if (food !=null && map.at(i, k).getGround().toString().contains(food)){
						target = map.at(i,k);
						isGround = true;
						break outerloop;
					}
					else if (food2!=null && map.at(i, k).getGround().toString().contains(food2)) {
						target = map.at(i,k);
						isGround = true;
						break outerloop;

					}
					else if (foodItem!=null&&map.at(i, k).getItems().toString().contains(foodItem.toString())){
						target = map.at(i,k);
						isGround = false;
						break outerloop;
					}
					else if(foodItem2!=null&&map.at(i, k).getItems().toString().contains(foodItem2.toString()))
					{
						target = map.at(i,k);
						isGround = false;
						break outerloop;
					}
					else if(foodMisc!=null&&map.at(i, k).getItems().toString().contains(foodMisc.toString()))
					{
						target = map.at(i,k);
						isGround = false;
						break outerloop;
					}
					
				}
	
			}		
		//tracking action for target
		int currentDistance = distance(here, target);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(destination, target);
				if (newDistance < currentDistance) {
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}
		//If the dino is on the same grid block 
		if (currentDistance == 0) 
		{
			if (isGround == true) {
				here.setGround(new Dirt());
				return new HealAction(10);
			}
			else if (isGround== false) {
				int health;
				for (int j = 0; j < here.getItems().size(); j++) {
					if (here.getItems().get(j).toString().contains(foodItem.toString())) {
						here.removeItem(here.getItems().get(j));
						health = foodItem.asFood().getFoodValue();
						return new HealAction(health);
					}
					if (here.getItems().get(j).toString().contains(foodItem2.toString())) {				
						here.removeItem(here.getItems().get(j));
						health = foodItem.asFood().getFoodValue();
						return new HealAction(health);
					}
					if (here.getItems().get(j).toString().contains(foodMisc.toString())) {
						here.removeItem(here.getItems().get(j));
						health = foodItem.asFood().getFoodValue();
						return new HealAction(health);
					}
				}
				
				
			}
		
				
		}
		//Wander Behaviour if no target is found
		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
            	actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }
		
		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
	
		return null;
	}
	/**
	 * Compute the Manhattan distance between two locations.
	 * 
	 * @param a the first location
	 * @param b the first location
	 * @return the number of steps between a and b if you only move in the four cardinal directions.
	 */
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}