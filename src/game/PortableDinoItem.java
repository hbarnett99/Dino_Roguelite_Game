package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableDinoItem extends Item {
	
	private int itemValue;

	public PortableDinoItem(String name, char displayChar, int initItemValue) {
		super(name, displayChar, true);
		itemValue = initItemValue;
	}
	
	public int getItemValue() {
		return itemValue;
	}
}
