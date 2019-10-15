package game;

import edu.monash.fit2099.engine.Location;
import java.util.ArrayList;

public class Tree extends Land {
	private int age = 0;
	
	private ArrayList<Location> locations = new ArrayList<>();
	
	public Tree() {
		super('+');
		//this.addSkill(EnumCollection.EDIBLE);
	}
		

	@Override
	public void tick(Location location) {
		super.tick(location);

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 10)
			displayChar = 'T';
		
		/*
		Checks if the location is within bounds of map -1 to know if it can grow trees next to it
		*/
		try {
		//if (location.map().getYRange().contains(location.y()) && location.map().getYRange().contains(location.x())) {
		if (checkSurroundings(location)){
			locations = getSurroundings(location);
			//randomly grows grass
			for (int i = 0; i < locations.size(); i++) {
				if (locations.get(i).getGround().toString().contains("Dirt") || locations.get(i).getGround().toString().contains("Grass")) {
					double random = Math.random();
					if (random < 0.005) {
						//System.out.println("Tree");
						//System.out.println(locations.get(i).getGround());
						locations.get(i).setGround(new Tree());
						
						//System.out.println(locations.get(i).getGround());
						
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
		
		
		//location.map().at(x, y);
		
		//this.createTrees(location);
	
	}
}
//this is a test