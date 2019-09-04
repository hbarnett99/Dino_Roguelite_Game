package edu.monash.fit2099.engine;

/**
 * An interface for representing a collection of any kind of enum.
 * A practical alternative to type introspection and other problems.
 *
 */
public interface Skilled {
	boolean hasSkill(Enum<?> skill);
	void addSkill(Enum<?> skill);
	void removeSkill(Enum<?> skill);
}