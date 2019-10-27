package game;

import edu.monash.fit2099.engine.Location;
import java.util.ArrayList;

/**
 * Class for ground Trees. They grow and spread around themselves
 */

public class Tree extends Land {
	private int age = 0;
	
	private ArrayList<Location> locations = new ArrayList<>();
	
	public Tree() {
		super('+');
	}
		

	@Override
	public void tick(Location location) {
		super.tick(location);

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 10)
			displayChar = 'T';
				
		/**
		 * Gets the surrounding ground types and if it fits the required type then random chance to grow a tree
		 */
		try {
		if (checkSurroundings(location)){
			locations = getSurroundings(location);
			//randomly grows grass
			for (int i = 0; i < locations.size(); i++) {
				if (locations.get(i).getGround().toString().contains("Dirt") || locations.get(i).getGround().toString().contains("Grass")) {
					double random = Math.random();
					if (random < 0.005) {
						locations.get(i).setGround(new Tree());						
					}
				}
			}
			
			for (int i = 0; i < locations.size(); i++) {
				locations.remove(i);
			}
			locations.clear();
		}
		
		//error handling
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Tree Out of Bounds");
			System.out.println(location.getGround());
			System.out.println(location.getDisplayChar());
			System.out.println(location.y());
		}
	}
}
