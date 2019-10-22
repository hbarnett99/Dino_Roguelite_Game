package game;

import edu.monash.fit2099.engine.Action;

import edu.monash.fit2099.engine.Actor;
import game.Dinosaur;
import edu.monash.fit2099.engine.GameMap;

public class HealAction extends Action {

	protected int healValue;
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
