package game;
import java.util.ArrayList;
import java.util.List;


import edu.monash.fit2099.engine.*;
import game.CarnivoreFood;

public class Plesioaur extends Dinosaur {

	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private CarnivoreFood carnFood;
	
	

	public Plesioaur(String name, char displayChar, int hitPoints) {
		super(name, 'F', 200);
		// TODO Auto-generated constructor stub
	}

	public Plesioaur(String name) {
		super(name, 'F', 100);
		hunger = 70;
		hitPoints = 50;
		this.behaviour = new HuntBehaviour("Fish", carnFood, new Corpse("Dead"));
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
	
}
