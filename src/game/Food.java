package game;

public abstract class Food extends PortableDinoItem {

    public enum FoodType {PLANT, MEAT};
    FoodType foodType;
    private int foodValue;

    public Food(String name, char displayChar, FoodType initFoodType, int initFoodValue) {
        super(name, displayChar);
        foodType = initFoodType;
        foodValue = initFoodValue;
        // TODO Auto-generated constructor stub
    }

	public int getFoodValue() {
		return foodValue;
	}
}
