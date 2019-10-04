package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableDinoItem extends Item {
	
	/*
	 * @param itemValue		The item's monetary value
	 */
	private int itemValue;

	public PortableDinoItem(String name, char displayChar, int initItemValue) {
		super(name, displayChar, true);
		itemValue = initItemValue;
	}
	
	/*
	 * @returns the item's monetary value;
	 */
	
	public int getItemValue() {
		return itemValue;
	}
}
