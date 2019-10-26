package game;

/**
 * Base class for all Food Items
 */
public abstract class Food extends PortableDinoItem {

	/**
	 * Enum for the food's type, so different dinosaurs can eat their desired food.
	 */	
    public enum FoodType {PLANT, MEAT, MARINE};
    
    /**
     *Store the enum variable
     */
    FoodType foodType;
    
    /**
     * The amount of hunger a dinosaur will lose when the food is eaten
     */
    public int foodValue;
    
	/**
	 * @param name			Name of the food
	 * @param displayChar	Display Character when it is on the ground
	 * @param initFoodType	Enum to determine whether food is Carnivore or Herbivore food
	 * @param initFoodValue	The amount of hunger it will replenish when it is eaten
	 * @param initSellValue	How much the food sells for
	 * @param initBuyValue	How much the food costs to buy
	 */
	    public Food(String name, char displayChar, FoodType initFoodType, int initFoodValue, int initSellValue, int initBuyValue) {
        super(name, displayChar, initSellValue, initBuyValue);
        foodType = initFoodType;
        foodValue = initFoodValue;
    }
    
    /**
     * Gets the foods value
     * @return the food item's foodValue
     */
	public int getFoodValue() {
		return foodValue;
	}
	
	
}
