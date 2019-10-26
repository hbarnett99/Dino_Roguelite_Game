package game;

import java.util.ArrayList;
import java.util.List;


import edu.monash.fit2099.engine.*;
import game.CarnivoreFood;
import game.Behaviour;

/**
 * Class for the Velociraptor Actor
 */
public class Velociraptor extends Dinosaur {

	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private CarnivoreFood carnFood;
	//find a protoceratops
	
		
	public Velociraptor(String name) {
		super(name, 'v', 100);
		hunger = 20;
		hitPoints = 50;
		this.behaviour = new HuntBehaviour("Proto", carnFood, new Corpse("Dead"));
		this.addSkill(SkillCollection.LAND_WALK);		
	}
	
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new EatAction(this));
	}

	/**
	 * Figure out what to do next.
	 * 
	 * FIXME: wanders around at random, or if no suitable MoveActions are available, it
	 * just stands there.  That's boring.
	 * 
	 * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
	 */
//	@Override
//	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
//		super.playTurn(actions, lastAction, map, display);
//	
//		return new DoNothingAction();
//	}
}
