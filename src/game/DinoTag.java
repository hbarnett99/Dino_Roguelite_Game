package game;


/*Super order is:
	(Name of the item, Character of the item, Portability)  
	*/

public class DinoTag extends PortableDinoItem {

	public DinoTag() {
		super("Dino Tag", '!', 0, 0);
		this.addSkill(SkillCollection.DINO_TAG);
	}
}
