package game;

/*
 * a class to give the user the skill to tag dinos
 */

public class DinoTag extends SaleItem {

	public DinoTag() {
		super("Dino Tag", '!',false,  0, 0);
		this.addSkill(SkillCollection.DINO_TAG);
	}
}
