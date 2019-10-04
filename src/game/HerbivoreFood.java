package game;

public class HerbivoreFood extends Food {
	
/*
 * Food to be bought and given to Protoceratops to be eaten
 */

	public HerbivoreFood() {
		super("Herbivore Food", 'h', FoodType.PLANT, 50, 20, 20);
		addSkill(SkillCollection.HERBIVORE_FOOD);
		// TODO Auto-generated constructor stub
	}

}
