package game;

import edu.monash.fit2099.engine.Item;

public class SaleItem extends Item {
	
	/*
	 * @param itemValue		The item's monetary value
	 */
	protected int sellValue;
	protected int buyValue;


	public SaleItem(String name, char displayChar, boolean portable, int initSellValue, int initBuyValue) {
		super(name, displayChar, portable);
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * @returns the item's sell value;
	 */
	public int getSellValue() {
		return sellValue;
	}
	
	/*
	 * @returns the item's buy value;
	 */
	public int getBuyValue() {
		return buyValue;
	}
}



