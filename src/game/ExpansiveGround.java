package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public abstract class ExpansiveGround extends Ground {

	private ArrayList<Location> locations = new ArrayList<>();
	private String name;
	
	public ExpansiveGround(char displayChar) {
		super(displayChar);
		// TODO Auto-generated constructor stub
		
	}
	
	public ArrayList<Location> getSurroundings(Location location) {
		if (checkSurroundings(location)) {
			locations.add(location.map().at(location.x(), location.y()-1));//North
			locations.add(location.map().at(location.x()+1, location.y()-1));//NorthEast
			locations.add(location.map().at(location.x()+1, location.y()));//East
			locations.add(location.map().at(location.x()+1, location.y()+1));//SouthEast
			locations.add(location.map().at(location.x(), location.y()+1));//South
			locations.add(location.map().at(location.x()-1, location.y()+1));//SouthWest
			locations.add(location.map().at(location.x()-1, location.y()));//West
			locations.add(location.map().at(location.x()-1, location.y()-1));//NorthWest
			
			

			//checkTopMap(location);
		}
		return locations;
	}
	
	public boolean checkSurroundings(Location location) {
		boolean inBounds = false;
		if (location.y() <= location.map().getYRange().max()-1 && location.y() >=2 && location.x() >= 2 && location.x() <= location.map().getXRange().max()) {
			inBounds = true;
		}
		return inBounds;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}

}
