package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.ActorLocations;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.World;

public class HuntBehaviour extends Action implements Behaviour {
	private Actor target;
	GameMap map;
	
	public HuntBehaviour() {
		
	}
	@Override
	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		
	outerloop:
		for (int i = 0; i < map.getXRange().max(); i++) {
			for (int k = 0; k < map.getYRange().max(); k++) {
				if (map.isAnActorAt(map.at(i, k))) {
					if (map.at(i, k).getActor().toString().contains("Proto")) {
						target = map.getActorAt(map.at(i, k));
						break outerloop;
					}
					
				}
				
			}

		}
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
