package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.*;

/**
 * Class for the ground type Reed
 */

public class Reed extends ExpansiveGround {

	/**
	 * Array of surrounding locations
	 */
	private ArrayList<Location> locations = new ArrayList<>();

	/**
	 * Constructor sets super's conditions
	 */
	public Reed() {
		super('(');
		setName("Reed");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		
		//Number of Reeds around
		int numOfReeds = 0;
		
		//Used for chance occurrences
		double random = Math.random();
		
		if(random <= 0.01) {
			if (!location.containsAnActor())
			location.map().addActor(new Fish(), location);
		}
		
		try {
			if (checkSurroundings(location)){
				locations = getSurroundings(location);
				
				//Checks how many reeds are surrounding the current tile
				for (int i = 0; i < locations.size(); i++) {
					if (locations.get(i).getGround().toString().contains("Reed")) {
						numOfReeds++;
					}
				}
				
				//returns the current tile to water if the there are more than 6 Reeds around it
				if(numOfReeds >= 6) {
						location.setGround(new Water());
				}
				
				for (int i = 0; i < locations.size(); i++) {
					locations.remove(i);
				}
				
				//Clears the surroundings arraylist
				locations.clear();
			}
			
			//error handling
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Reed Out of Bounds");
				System.out.println(location.getGround());
				System.out.println(location.getDisplayChar());
				System.out.println(location.y());
			}
	}
	
	/**
	 * Checks if the Actor can enter a water tile
	 * @param actor			The actor to check
	 * @return waterWalk	Bool that is true if that actor has skill WATER_WALK
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
