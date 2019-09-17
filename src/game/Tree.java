package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.ArrayList;

import edu.monash.fit2099.engine.GameMap;


public class Tree extends Ground {
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
		if (age == 20)
			displayChar = 'T';
		
	//	location.map().at(x, y);
		
		this.createTrees(Location location,  this.map);
	
	}
	public void createTrees(Location location, GameMap map) {
		
		//double multiplier = Math.random();
		//Location here = map.at(location.x(), location.y());
		
		locations.add(map.at(location.x(), location.y()-1));//North
		locations.add(map.at(location.x()+1, location.y()-1));//NorthEast
		locations.add(map.at(location.x()+1, location.y()));//East
		locations.add(map.at(location.x()+1, location.y()+1));//SouthEast
		locations.add(map.at(location.x(), location.y()+1));//South
		locations.add(map.at(location.x()-1, location.y()+1));//SouthWest
		locations.add(map.at(location.x()-1, location.y()));//West
		locations.add(map.at(location.x()-1, location.y()-1));//NorthWest
		
		for (int i = 0; i < locations.size(); i++) {
			if (locations.get(i).getGround().getDisplayChar() == '.') {
				if (Math.random() < 0.9) {
					locations.get(i).setGround(new Tree());
				}
			}
		}		
		
	}
}
//this is a test