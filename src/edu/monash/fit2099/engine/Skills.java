package edu.monash.fit2099.engine;

import java.util.HashSet;
import java.util.Set;

/**
 * A collection of Skill objects.
 * 
 * 
 * The original purpose of Skills was to allow game clients to check whether Actors could do particular Actions,
 * whether Items provided (or required) certain abilities, whether terrain was passable under particular
 * circumstances, etc.  Consider Skills an all-purpose mechanism for enabling game capabilities, statuses, etc.
 * 
 * Don't be too literal about the name. You can keep all sorts of things in here.
 * PURPLE, FLAT, HOUSE_RAVENCLAW, TEAM_HERBIVORE, etc.  
 * 
 * Any Enum type can be used to represent a Skill, so these classes can and should be defined in the game client.
 */
public class Skills implements Skilled {
	private Set<Object> skillSet = new HashSet<Object>();

	public boolean hasSkill(Enum<?> skill) {
		return skillSet.contains(skill);
	}

	public void addSkill(Enum<?> skill) {
		skillSet.add(skill);
	}

	public void removeSkill(Enum<?> skill) {
		skillSet.remove(skill);
	}
}
