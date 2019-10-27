package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class Pteradon extends Dinosaur {

	/**
	 * 
	 * @param name The name of the Pteradon
	 * @param displayChar the char on the map
	 * @param hitPoints how much hp the dino has
	 */
	public Pteradon(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints, Egg.DinosaurType.PTERANODON);
		// TODO Auto-generated constructor stub
	}
	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private CarnivoreFood carnFood;
	
	//adds skills and behaviours to allow dino to do its thing
	public Pteradon(String name) {
		super(name, 'N', 100, Egg.DinosaurType.PTERANODON);
		hunger = 70;
		hitPoints = 50;
		this.behaviour = new HuntBehaviour("Fish", carnFood, new Corpse("Dead"));
		this.addSkill(SkillCollection.WATER_WALK);
		this.addSkill(SkillCollection.LAND_WALK);

		// TODO Auto-generated constructor stub
	}

}
