package game;

/**
 * Base class for any item that can be picked up and dropped.
 */
public abstract class PortableDinoItem extends SaleItem {
	
	/**
	 * Constructor
	 * @param name			The name of the item
	 * @param displayChar	The display character of the item
	 * @param initSellValue	How much the item costs to sell to a vendor
	 * @param initBuyValue	How much the item costs to buy from a vendor
	 */
	public PortableDinoItem(String name, char displayChar, int initSellValue, int initBuyValue) {
		super(name, displayChar, true, initSellValue, initBuyValue);
	}
}
