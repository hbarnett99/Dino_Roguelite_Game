package game;

import edu.monash.fit2099.engine.Item;

/**
 * The base class for an item that can be bought or sold
 */
public abstract class SaleItem extends Item {
	
	/**
	 * How much the item is sold to the shop for
	 */
	protected int sellValue;
	
	/**
	 * How much the item is purchased for
	 */
	protected int buyValue;

	/**
	 * Constructor
	 * @param name			Name of the item
	 * @param displayChar	Display character of the item
	 * @param portable		Is the item able to be picked up and dropped by actors
	 * @param initBuyValue	How much the item is purchased for
	 * @param initSellValue	How much the item is sold to the shop for
	 */
	public SaleItem(String name, char displayChar, boolean portable, int initBuyValue, int initSellValue) {
		super(name, displayChar, portable);
		sellValue = initSellValue;
		buyValue = initBuyValue;
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @return the item's sell value;
	 */
	public int getSellValue() {
		return sellValue;
	}
	
	/**
	 * @return the item's buy value;
	 */
	public int getBuyValue() {
		return buyValue;
	}
}



