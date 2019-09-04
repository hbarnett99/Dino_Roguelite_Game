package edu.monash.fit2099.engine;

import edu.monash.fit2099.interfaces.GroundInterface;

/**
 * Class representing terrain type
 */
public abstract class Ground implements GroundInterface, Skilled, Printable {

	private Skills skills = new Skills();
	protected char displayChar;

	/**
	 * Constructor.
	 *
	 * @param displayChar character to display for this type of terrain
	 */
	public Ground(char displayChar) {
		this.displayChar = displayChar;
	}

	public char getDisplayChar() {
		return displayChar;
	}

	/**
	 * Returns an empty Action list.
	 *
	 * @param actor the Actor acting
	 * @param location the current Location
	 * @param direction the direction of the Ground from the Actor
	 * @return a new, empty collection of Actions
	 */
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions();
	}

	/**
	 * Override this to implement impassable terrain, or terrain that is only passable if conditions are met.
	 *
	 * @param actor the Actor to check
	 * @return true
	 */
	public boolean canActorEnter(Actor actor) {
		return true;
	}

	/**
	 * Ground can also experience the joy of time.
	 * @param location The location of the Ground 
	 */
	public void tick(Location location) {
	}
	
	/**
	 * Override this to implement terrain that blocks thrown objects but not movement, or vice versa
	 * @return true
	 */
	public boolean blocksThrownObjects() {
		return false;
	}

	/**
	 * Check whether this Ground type has the given skill.
	 * 
	 * @param skill the Skill to check
	 * @return true if and only if this Ground has the given skill.
	 */
	public boolean hasSkill(Enum<?> skill) {
		return skills.hasSkill(skill);
	}

	/**
	 * Add the given Skill to this Ground.
	 * 
	 * @param skill the Skill to add
	 */
	public void addSkill(Enum<?> skill) {
		skills.addSkill(skill);
	}

	/**
	 * Remove the given Skill from this Ground.
	 * 
	 * @param skill the Skill to remove.
	 */
	public void removeSkill(Enum<?> skill) {
		skills.removeSkill(skill);
	}
}
