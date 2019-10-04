package game;

public class HerbivoreFood extends Food {
	
	/*Super order is:
	  (Name of the item, Character of the item, enum of the food type, food value, cost of the item)  
	*/

	public HerbivoreFood() {
		super("Herbivore Food", 'h', FoodType.PLANT, 50, 20);
		addSkill(SkillCollection.HERBIVORE_FOOD);
		// TODO Auto-generated constructor stub
	}

}
