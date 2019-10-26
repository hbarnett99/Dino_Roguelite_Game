package edu.monash.fit2099.interfaces;

import game.Food;
import game.SaleItem;

/**
 * This interface provides the ability to add methods to Ground, without modifying code in the engine,
 * or downcasting references in the game.   
 */
public interface ItemInterface {

	/**
	 * Casts an item into Food
	 * @return castedItem	the itemToCast casted as Food
	 */
	public default Food asFood() {
		return this instanceof Food ? (Food) this : null;
	}
	
	/**
	 * Casts an item into a SaleItem
	 * @return castedItem	the itemToCast casted as a SaleItem
	 */
	public default SaleItem asSaleItem() {
		return this instanceof SaleItem ? (SaleItem) this : null;
	}

}
