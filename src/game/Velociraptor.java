package game;

import java.util.ArrayList;
import java.util.List;


import edu.monash.fit2099.engine.*;
import game.Behaviour;

public class Velociraptor extends Actor {

	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private Behaviour behaviour;
	
	//find a protoceratops
	
		
	public Velociraptor(String name) {
		super(name, 'v', 100);
		
		this.behaviour = new HuntBehaviour("Proto");
		
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
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
	 {
		 Action action = behaviour.getAction(this, map);
			//Action action = factory.getAction(this, map);
			if(action != null)
				return action;
			
			
		}
		
		return new DoNothingAction();

	}
}
