package game;

public abstract class Food extends PortableDinoItem {

	/* 
	 * Enum for the food's type, so different dinosaurs can eat their desired food.
	 * @param FoodType 		store the enum variable
	 * @param foodValue 	the amount of hunger a dinosaur will lose when the food is eaten
	 */	
	
    public enum FoodType {PLANT, MEAT};
    FoodType foodType;
    private int foodValue;

    public Food(String name, char displayChar, FoodType initFoodType, int initFoodValue, int initItemValue) {
        super(name, displayChar, initItemValue);
        foodType = initFoodType;
        foodValue = initFoodValue;
        // TODO Auto-generated constructor stub
    }
    
    /*
     * @return the food item's foodValue
     */

	public int getFoodValue() {
		return foodValue;
	}
	
	
}
