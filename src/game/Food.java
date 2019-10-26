package game;

public abstract class Food extends PortableDinoItem {

	/* 
	 * Enum for the food's type, so different dinosaurs can eat their desired food.
	 * @param FoodType 		store the enum variable
	 * @param foodValue 	the amount of hunger a dinosaur will lose when the food is eaten
	 */	
	
    public enum FoodType {PLANT, MEAT};
    FoodType foodType;
    public int foodValue;

    public Food(String name, char displayChar, FoodType initFoodType, int initFoodValue, int initSellValue, int initBuyValue) {
        super(name, displayChar, initSellValue, initBuyValue);
        foodType = initFoodType;
        foodValue = initFoodValue;
    }
    
    /*
     * @return the food item's foodValue
     */

	public int getFoodValue() {
		return foodValue;
	}
	
	
}
