package game;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;

public class Water extends ExpansiveGround {
	
	private ArrayList<Location> locations = new ArrayList<>();
	
	public Water() {
		super('~');
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
		
		try {
		//if (location.map().getYRange().contains(location.y()) && location.map().getYRange().contains(location.x())) {
		if (checkSurroundings(location)){
			locations = getSurroundings(location);
			
			//randomly grows grass
			for (int i = 0; i < locations.size(); i++) {
				double random = Math.random();
				if (locations.get(i).getGround().toString().contains("Dirt") || locations.get(i).getGround().toString().contains("Grass")) {
					if (random <= 0.01) {
						location.setGround(new Reed());
					}
				}
				else if (locations.get(i).getGround().toString().contains("Reed")){
					if (random <= 0.005) {
						location.setGround(new Reed());
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
			System.out.println("ERROR");
			System.out.println(location.getGround());
			System.out.println(location.getDisplayChar());
			System.out.println(location.y());
		}
		
		
		//location.map().at(x, y);
		
		//this.createTrees(location);
	
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
