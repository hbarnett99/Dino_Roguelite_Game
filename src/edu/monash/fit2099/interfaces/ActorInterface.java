package edu.monash.fit2099.interfaces;

import game.*;

/**
 * This interface provides the ability to add methods to Actor, without modifying code in the engine,
 * or downcasting references in the game.   
 */

public interface ActorInterface {

	public default  Dinosaur asDinosaur() {
		return this instanceof Dinosaur ? (Dinosaur) this : null;
	}
	
	public default  Player asPlayer() {
		return this instanceof Player ? (Player) this : null;
	}
}
