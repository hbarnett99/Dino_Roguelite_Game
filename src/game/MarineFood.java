package game;

/**
 * Class for food to be bought and given to Protoceratops to be eaten
 */
public class MarineFood extends Food {

	/**
	 * Constructor
	 * Sets super conditions and adds Marine skill
	 */
	public MarineFood() {
		super("Marine Food", 'h', FoodType.MARINE, 50, 150, 150);
		addSkill(SkillCollection.MARINE_FOOD);
	}
}
