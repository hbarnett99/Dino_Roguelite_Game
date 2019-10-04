package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */
public abstract class PortableDinoItem extends Item {
	
	/*
	 * @param itemValue		The item's monetary value
	 */
	protected int sellValue;
	protected int buyValue;

	public PortableDinoItem(String name, char displayChar, int initSellValue, int initBuyValue) {
		super(name, displayChar, true);
		sellValue = initSellValue;
		buyValue = initBuyValue;
	}
	
	/*
	 * @returns the item's monetary value;
	 */
	
	public int getSellValue() {
		return sellValue;
	}
	
	public int getBuyValue() {
		return buyValue;
	}
}
