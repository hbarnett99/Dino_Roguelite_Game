package game;

/**
 * Class for food to be bought and given to Protoceratops to be eaten
 */

public class HerbivoreFood extends Food {
	

	/**
	 * Constructor
	 * Sets super conditions and adds herbivore skill
	 */
	public HerbivoreFood() {
		super("Herbivore Food", 'h', FoodType.PLANT, 50, 20, 20);
		addSkill(SkillCollection.HERBIVORE_FOOD);
		// TODO Auto-generated constructor stub
	}

}
