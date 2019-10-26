package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

	/**
	 * Class for the Heal Action of an actor
	 */

public class HealAction extends Action {

	/**
	 * Value to heal by
	 */
	protected int healValue;
	
	/**
	 * Constructor
	 * @param health	the amount to heal by
	 */
	public HealAction(int health) {
	healValue = health;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		
		actor.asDinosaur().increaseHunger(healValue);
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
