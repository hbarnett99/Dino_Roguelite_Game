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

public class HuntBehaviour extends Action implements Behaviour {
	private Actor target;
	GameMap map;
	private Random random = new Random();
	private String hunted = "";
	public HuntBehaviour(String hunted) {
		this.hunted = hunted;
	}
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<Action>();
		Location here = map.locationOf(actor);
		
		
	
		//finding target
		/*
		for (int i = 0; i < map.getXRange().max(); i++) {
			for (int k = 0; k < map.getYRange().max(); k++) {
				if (map.isAnActorAt(map.at(i, k))) {
					if (map.at(i, k).getActor().toString().contains(hunted)) {
						target = map.getActorAt(map.at(i, k));
						break outerloop;
					}
					
				}
				
			}

		}
		*/
		int minX;
		int minY;
		int maxX;
		int maxY;
		
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
		
		outerloop:
		for (int i = minX; i < maxX; i++) {
			for (int k = minY; k < maxY; k++) {
				if (map.isAnActorAt(map.at(i, k))) {
					if (map.at(i, k).getActor().toString().contains(hunted)) {
						target = map.getActorAt(map.at(i, k));
						break outerloop;
					}						
				}					
			}
		}
		
		//tracking action
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
		//eating action
		Location there = map.locationOf(target);

		if(there !=null) {
			if (distance(here ,there) <3) {
				return new EatAction(target);
			}
		}
		//Wander Behaviour
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
		map.locationOf(target).addItem(corpse);
		
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
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}
