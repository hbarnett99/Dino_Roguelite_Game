package game;

import edu.monash.fit2099.engine.Location;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Land {

	public Dirt() {
		super('.');
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		
		if(Math.random() < 0.005) {
			location.setGround(new Grass());
		}		
	}
}
