package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Location;
import java.util.concurrent.ThreadLocalRandom;

public class SeekBehaviour implements Behaviour {

	private Location target = null;
	
	
	public SeekBehaviour() {
		//
		//FIND CLOSEST TREE
		//		
			
		//this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(!map.contains(actor))
		return null;
		
		Location here = map.locationOf(actor);
		
		//finds a tree
		
					
		for (int i = 0; i < here.getExits().size(); i++) {
			
			if(here.getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here;
			}
			//checks circle south east
			else if(here.map().at(here.x()+5, here.y()+5).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x()+5, here.y()+5);
				
			}
			//south
			else if(here.map().at(here.x(), here.y()+5).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x(), here.y()+5);
			}
			//checks south west
			else if(here.map().at(here.x()-5, here.y()+5).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x()-5, here.y()+5);
				
			}
			//west
			else if(here.map().at(here.x()-5, here.y()).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x()-5, here.y());
			}
			//NW
			else if(here.map().at(here.x()-5, here.y()-5).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x()-5, here.y()-5);
				
			}
			//North
			else if(here.map().at(here.x(), here.y()-5).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x(), here.y()-5);
			}
			//NE
			else if(here.map().at(here.x()+5, here.y()-5).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x()+5, here.y()-5);
				
			}
			else if(here.map().at(here.x()+5, here.y()).getExits().get(i).getDestination().getGround().toString().contains("Tree")){
				target = here.map().at(here.x()+5, here.y());
			}
			else {
				target = here.map().at(here.x()+ThreadLocalRandom.current().nextInt(-5, 5 + 1),here.y()+ThreadLocalRandom.current().nextInt(-5, 5 + 1));			
			}
		}
					
				
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