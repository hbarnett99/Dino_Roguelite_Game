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
	
	/**
	 * Constructor for a Velociraptor
	 * @param name name of this dino
	 */
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

}
