package game;
import edu.monash.fit2099.engine.*;

 /*
 * A class that extends ground. If a Player is standing on it, gives access to the Shop skill
 */
public class Shop extends Land{

	public Shop() {
		super('-');
		addSkill(SkillCollection.SHOP);
	}

	@Override
	public void tick(Location location) {
		super.tick(location);
	}
}
