package game;

import edu.monash.fit2099.engine.*;

/**
 * Class for the Fish
 */
public class Fish extends Dinosaur {

	// Will need to change this to a collection if Protoceratops gets additional Behaviours.
	private Behaviour behaviour;
	GameMap map;
	int age = 0;
	
	/** 
	 * Constructor.
	 * All fish are represented by a '^' and have 1 hit point.
	 */
	
	public Fish() {
		super("Fish", '>', 1);
		this.addSkill(SkillCollection.WATER_WALK);
		behaviour = new WanderBehaviour();
		foodValue = 10;
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new AttackAction(this));
	}

	/**
	 *
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		Action wander = behaviour.getAction(this, map);
		age++;
		if (age >= 20) {
			map.removeActor(this);
			System.out.println("A Fish has died");
		}
		if (wander != null)
			return wander;
		
		return new DoNothingAction();
	}

}
