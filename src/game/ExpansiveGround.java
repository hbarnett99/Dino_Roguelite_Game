package game;

import java.util.ArrayList;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * Ground that can look at its surroundings
 */
public abstract class ExpansiveGround extends Ground {

	private ArrayList<Location> locations = new ArrayList<>();
	private String name;
	
	public ExpansiveGround(char displayChar) {
		super(displayChar);		
	}
	
	/**
	 * Creates and returns the surrounding locations of the current ground
	 * @param location		The current location of the ground tile
	 * @return locations	Array of location of the immediate surroundings of the ground
	 */
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
	
	/**
	 * Checks if the current location is within the boundaries of the map
	 * @param location		The location of the ground characters
	 * @return inBounds		Bool check on whether the current location is not on the edge of the map
	 */
	public boolean checkSurroundings(Location location) {
		boolean inBounds = false;
		if (location.y() <= location.map().getYRange().max()-1 && location.y() >=2 && location.x() >= 2 && location.x() <= location.map().getXRange().max()) {
			inBounds = true;
		}
		return inBounds;
	}
	
	/**
	 * Gets the ground's name
	 * @return name		The name of the ground
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the ground's name
	 * @param newName	The new name of the ground
	 */
	public void setName(String newName) {
		name = newName;
	}

}
