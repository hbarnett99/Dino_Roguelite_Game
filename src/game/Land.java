package game;

import edu.monash.fit2099.engine.Actor;

public abstract class Land extends ExpansiveGround {

	public Land(char displayChar) {
		super(displayChar);
		// TODO Auto-generated constructor stub
	}
	
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
