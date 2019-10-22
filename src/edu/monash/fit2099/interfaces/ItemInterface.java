package edu.monash.fit2099.interfaces;

import game.Food;

/**
 * This interface provides the ability to add methods to Ground, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ItemInterface {

	public default Food asFood() {
		return this instanceof Food ? (Food) this : null;
	}

}
