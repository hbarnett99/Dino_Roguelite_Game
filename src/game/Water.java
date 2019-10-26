package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

/**
 * Class for Water ground
 */

public class Water extends ExpansiveGround {
	
	/**
	 * Array of locations around current tile
	 */
	private ArrayList<Location> locations = new ArrayList<>();
	
	/**
	 * Constructor
	 * Fills super's requirements
	 */
	public Water() {
		super('~');
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		
		try {
		//if (location.map().getYRange().contains(location.y()) && location.map().getYRange().contains(location.x())) {
		if (checkSurroundings(location)){
			locations = getSurroundings(location);
			
			//randomly turns into Reeds
			for (int i = 0; i < locations.size(); i++) {
				double random = Math.random();
				//Chance of turning into a Reed if it is next to land
				if (locations.get(i).getGround().toString().contains("Dirt") || locations.get(i).getGround().toString().contains("Grass")) {
					if (random <= 0.01) {
						location.setGround(new Reed());
					}
				}
				//Chance of turning into a Reed if it is next to another Reed
				else if (locations.get(i).getGround().toString().contains("Reed")){
					if (random <= 0.005) {
						location.setGround(new Reed());
					}
				}
			}
				
			for (int i = 0; i < locations.size(); i++) {
				locations.remove(i);
			}
			//Clears ArrayList
			locations.clear();
		}
		
		//error handling
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR");
			System.out.println(location.getGround());
			System.out.println(location.getDisplayChar());
			System.out.println(location.y());
		}	
	}
	
	/**
	 * Checks if an Actor can traverse water
	 * @param actor			The actor to check
	 * @return waterWalk	Bool returns true if actor has skill WATER_WALK
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		boolean waterWalk = false;
		if (actor.hasSkill(SkillCollection.WATER_WALK)) {
			waterWalk = true;
		}
		return waterWalk;
	}
	
}
