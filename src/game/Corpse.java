package game;

import edu.monash.fit2099.engine.Location;

/**
 * An item to replace dead dinos.
 *
 */

public class Corpse extends Food {
	
	/**
	 * Constructor 
	 * @param name			The name of the corpse
	 */
	public Corpse(String name) {
		super(name, 'c', FoodType.MEAT, 50, 15, 0);
	}
	
	/**
	 * Removes the corpse
	 * @param location		Location of the corpse
	 */
	public void removeCorpse(Location location) {
		location.removeItem(this);
	}

}