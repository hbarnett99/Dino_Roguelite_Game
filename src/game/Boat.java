package game;

/**
 * Class to for a boat to allow the crossing of water
 */

public class Boat extends SaleItem {

	public Boat() {
		super("Boat", 'b', false, 15, 5);
		this.addSkill(SkillCollection.WATER_WALK);
		// TODO Auto-generated constructor stub
	}
}
