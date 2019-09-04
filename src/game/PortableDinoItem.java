package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableDinoItem extends Item {

	public PortableDinoItem(String name, char displayChar) {
		super(name, displayChar, true);
	}
}
