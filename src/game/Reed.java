package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;
//import sun.security.action.GetLongAction;

public class Reed extends ExpansiveGround {

	private ArrayList<Location> locations = new ArrayList<>();

	public Reed() {
		super('(');
		setName("Reed");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		
		int numOfReeds = 0;
		
		double random = Math.random();
		
		if(random <= 0.01) {
			if (!location.containsAnActor())
			location.map().addActor(new Fish(), location);
		}
		
		try {
			//if (location.map().getYRange().contains(location.y()) && location.map().getYRange().contains(location.x())) {
			if (checkSurroundings(location)){
				locations = getSurroundings(location);
				
				for (int i = 0; i < locations.size(); i++) {
					if (locations.get(i).getGround().toString().contains("Reed")) {
						numOfReeds++;
					}
				}
				
				if(numOfReeds >= 6) {
						location.setGround(new Water());
				}
				
				for (int i = 0; i < locations.size(); i++) {
					locations.remove(i);
				}
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
	
	@Override
	public boolean canActorEnter(Actor actor) {
		boolean waterWalk = false;
		if (actor.hasSkill(SkillCollection.WATER_WALK)) {
			waterWalk = true;
		}
		return waterWalk;
	}
}
