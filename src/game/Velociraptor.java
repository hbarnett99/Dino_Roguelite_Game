package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.*;
import game.Behaviour;

public class Velociraptor extends Actor {

	private Behaviour behaviour;	
	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private Random rand = new Random();
	//find a protoceratops
	
		
	public Velociraptor(String name) {
		super(name, 'v', 100);
		
		
		
	}
	
	
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new AttackAction(this));
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
		for (Behaviour factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return actions.get(rand.nextInt(actions.size()));

	}
}
