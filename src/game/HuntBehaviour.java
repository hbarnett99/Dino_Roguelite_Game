package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Exit;

//
//Used for all carnivores
//

/**
 * Behaviour for dinosaurs to actively seek food / other actors they can eat *
 */
public class HuntBehaviour extends Action implements Behaviour {
	private Actor target;
	GameMap map;
	private Random random = new Random();
	private String hunted;
	private String hunted2;
	private Item foodItem1;
	
	private Item Corpses;
	private Item itemTarget;
	private Location targetLocation;
	private Boolean isActor = false;
	
	/**
	 * Constructor.
	 *
	 * @param hunted      A string representing the type of creature to be hunted
	 * @param foodItem1   An item the dinosaur wants to eat, normally a type of Food
	 * @param hitPoints   Dinos starting number of hitpoints
	 * Different constructors so that different dinos with different needs can all use the same behaviour and still work
	 */
	public HuntBehaviour(String hunted) {
		this.hunted = hunted;
	}
	public HuntBehaviour(String hunted, CarnivoreFood carnivoreFood, Corpse corpse) {
		this.hunted = hunted;
		this.foodItem1 = new CarnivoreFood();
		this.Corpses = corpse;
	}
	public HuntBehaviour(String hunted, String hunted2, CarnivoreFood carnivoreFood, Corpse corpse) {
		this.hunted = hunted;	
		this.hunted2 = hunted2;
		this.foodItem1 = carnivoreFood;
		this.Corpses = corpse;
	}
	public HuntBehaviour(String hunted, MarineFood marnFood, Corpse corpse) {
		this.hunted = hunted;	
		this.foodItem1 = marnFood;
		this.Corpses = corpse;
	}
	
	/**
	 * this code block will search for a target, move towards the target, eat the target, OR if no target found it will randomly wander around
	 * @returns an action, usually going to be a moveAction to the dinos target or a HealAction when the dino eats something
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<Action>();
		Location here = map.locationOf(actor);
		/**
		 * @param minX actors location x - 5
		 * @param minY 
		 * @param maxX
		 * @param maxY
		 */
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
				if (map.isAnActorAt(map.at(i, k))) {
					//Checks for either of the two Actor targets
					if (hunted!=null&&map.at(i, k).getActor().toString().contains(hunted)) {
						target = map.getActorAt(map.at(i, k));
						isActor = true;
						break outerloop;
					}
					else if (hunted2!=null&&map.at(i, k).getActor().toString().contains(hunted2)) {
						target = map.getActorAt(map.at(i, k));
						isActor = true;
						break outerloop;
					}
				}
				//Checks for the item targets/ corpses
				else if (foodItem1!=null&&map.at(i, k).getItems().toString().contains(foodItem1.toString())) {
					targetLocation = map.at(i,k);
					itemTarget = foodItem1;
					isActor = false;
					break outerloop;
				}
				
				else if (Corpses!=null&&map.at(i, k).getItems().toString().contains(Corpses.toString())) {
					targetLocation = map.at(i,k);
					itemTarget = Corpses;
					isActor = false;
					break outerloop;
				}
			}
		}
		
		//tracking action for an actor
		if (isActor== true) {
			if(map.locationOf(target)!=null) {
				Location there = map.locationOf(target);
				int currentDistance = distance(here, there);
				for (Exit exit : here.getExits()) {
					Location destination = exit.getDestination();
					if (destination.canActorEnter(actor)) {
						int newDistance = distance(destination, there);
						if (newDistance < currentDistance) {
							return new MoveActorAction(destination, exit.getName());
							
						}
					}
				}
			}
		}
		//tracking action for an item, sets a different type of target
		else if (isActor==false) {
			if(targetLocation!=null) {
				int currentDistance = distance(here, targetLocation);
				for (Exit exit : here.getExits()) {
					Location destination = exit.getDestination();
					if (destination.canActorEnter(actor)) {
						int newDistance = distance(destination, targetLocation);
						if (newDistance < currentDistance) {
							return new MoveActorAction(destination, exit.getName());
						}
					}
				}
			}
		}
		//eating action
		Location there = map.locationOf(target);
		/**
		 * @returns an EatAction for an actor or a HealAction for an Item if the Dino is on the same square
		 */
		if(there !=null && target!=actor) {
			if (distance(here ,there) <3) {
				if (isActor == true) {
					return new EatAction(target);
				}
			}
		}
		/*
		 * checks grid square to see if the targetItem is there
		 * Could do this in one if statement with itemTarget
		 */
		else if(targetLocation!=null) {
			for (int j = 0; j < targetLocation.getItems().size(); j++) {
				if (targetLocation.getItems().get(j).toString().contains(foodItem1.toString())) {
					int health = foodItem1.asFood().getFoodValue();
					targetLocation.removeItem(targetLocation.getItems().get(j));
					return new HealAction(health);
				}
				
				if (targetLocation.getItems().get(j).toString().contains(Corpses.toString())) {
					int health = Corpses.asFood().getFoodValue();
					targetLocation.removeItem(targetLocation.getItems().get(j));
					System.out.print(health);
					return new HealAction(health);
					
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

	
	@Override
	public String execute(Actor actor, GameMap map) {
		Item corpse = new Corpse("Dead");
		if (target.getDisplayChar()!='>') {
			map.locationOf(target).addItem(corpse);
		}
		Actions dropActions = new Actions();
		for (Item item : target.getInventory())
			dropActions.add(item.getDropAction());
		for (Action drop : dropActions)		
			drop.execute(target, map);
		map.removeActor(target);
		
		return actor + " eats " + target + "." + System.lineSeparator()+
				target + " is dead.";
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "";
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
