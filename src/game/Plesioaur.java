package game;
import java.util.ArrayList;
import java.util.List;


import edu.monash.fit2099.engine.*;
import game.CarnivoreFood;
import game.Behaviour;

public class Plesioaur extends Dinosaur {

	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private Behaviour behaviour;
	private CarnivoreFood carnFood;
	
	

	public Plesioaur(String name, char displayChar, int hitPoints) {
		super(name, 'l', 200);
		// TODO Auto-generated constructor stub
	}

	public Plesioaur(String name) {
		super(name, 'F', 100);
		hunger = 20;
		hitPoints = 50;
		this.behaviour = new HuntBehaviour("Fish", carnFood, new Corpse("Fish"));
		this.addSkill(SkillCollection.WATER_WALK);
		// TODO Auto-generated constructor stub
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
		 hitPoints -=1;
		 if (hitPoints <= 0) {
			return new dieAction();
		}
		 Action action = behaviour.getAction(this, map);
			//Action action = factory.getAction(this, map);
			if(action != null)
				return action;
			
			return new DoNothingAction();
		}
		
		

	}
}
