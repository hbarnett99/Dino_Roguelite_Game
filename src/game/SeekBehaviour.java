package game;

import java.util.ArrayList;
import java.util.Random;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Ground;
import java.util.concurrent.ThreadLocalRandom;

public class SeekBehaviour implements Behaviour {

	private Location target = null;
	private String food;
	
	public SeekBehaviour(String foodSource) {
		//
		//FIND CLOSEST TREE
		//		
		food = foodSource;
		//this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(!map.contains(actor))
		return null;
		
		Location here = map.locationOf(actor);
		
		outerloop:
			for (int i = 0; i < map.getXRange().max(); i++) {
				for (int k = 0; k < map.getYRange().max(); k++) {
					if (map.at(i, k).getGround().toString().contains(food)) {
						target = map.at(i,k);
						break outerloop;
					}
					
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
		if (currentDistance == 0) {
			actor.heal(5);
			here.setGround(new Dirt());
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