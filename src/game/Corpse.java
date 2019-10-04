package game;

import edu.monash.fit2099.engine.Location;

/**
 * An item to replace dead dinos.
 *
 */

public class Corpse extends Food {
	
	private int sellValue = 15;

	public Corpse(String name) {
		super(name, 'c', FoodType.MEAT, 50, 15, 0);
		// TODO Auto-generated constructor stub
	}
	
	public int getSellValue() {
		return sellValue;
	}
	
	public void removeCorpse(Location location) {
		location.removeItem(this);
	}
}