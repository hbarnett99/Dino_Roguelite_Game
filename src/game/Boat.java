package game;

public class Boat extends SaleItem {

	public Boat() {
		super("Boat", 'b', false, 15, 5);
		this.addSkill(SkillCollection.WATER_WALK);
		// TODO Auto-generated constructor stub
	}
}
