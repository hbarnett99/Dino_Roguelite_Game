package game;

public class CarnivoreFood extends Food {
	
	/*Super order is:
	  (Name of the item, Character of the item, enum of the food type, food value, cost of the item)  
	*/

	public CarnivoreFood() {
		super("Carnivore Food", 'm', FoodType.MEAT, 100, 100);
		addSkill(SkillCollection.CARNIVORE_FOOD);
		// TODO Auto-generated constructor stub
	}

}
