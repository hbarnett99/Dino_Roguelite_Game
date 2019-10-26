package game;

import edu.monash.fit2099.engine.Actor;

/**
 * Class for solid ground called Land
 */

public abstract class Land extends ExpansiveGround {

	public Land(char displayChar) {
		super(displayChar);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Checks if the actor can travel across land
	 * @param actor		The actor to check
	 * @return canWalk	Bool returns true if the actor has the skill LAND_WALK
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		boolean canWalk;
		if (actor.hasSkill(SkillCollection.LAND_WALK))
			canWalk = true;
		else
			canWalk = false;
		return canWalk;
	}
}
