package edu.monash.fit2099.demo.conwayslife;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public interface Behaviour {
	
	/**
	 * A factory for creating actions. Chaining these together can result in an actor performing more complex tasks.
	 *
	 * @return an Action that actor can perform, or null if actor can't do this.
	 */
	Action getAction(Actor actor, GameMap map);
}
