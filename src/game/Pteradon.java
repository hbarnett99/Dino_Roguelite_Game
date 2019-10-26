package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class Pteradon extends Dinosaur {

	public Pteradon(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		// TODO Auto-generated constructor stub
	}
	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private CarnivoreFood carnFood;
	
	public Pteradon(String name) {
		super(name, 'N', 100);
		hunger = 70;
		hitPoints = 50;
		this.behaviour = new HuntBehaviour("Fish", carnFood, new Corpse("Dead"));
		this.addSkill(SkillCollection.WATER_WALK);
		this.addSkill(SkillCollection.LAND_WALK);

		// TODO Auto-generated constructor stub
	}

}
