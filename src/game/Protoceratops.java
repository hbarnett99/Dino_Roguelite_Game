package game;


import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * A herbivorous dinosaur.
 *
 */
public class Protoceratops extends Dinosaur {
	
	GameMap map;
	/** 
	 * Constructor.
	 * All Protoceratops are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Protoceratops
	 */
	public Protoceratops(String name) {
		super(name, 'd', 100, Egg.DinosaurType.PROTOCERATOPS);
		hunger = 20;
		hitPoints = 50;
		foodValue = 10;
		//behaviour = new WanderBehaviour();
		
		behaviour = new SeekBehaviour("Tree", new HerbivoreFood());
		this.addSkill(SkillCollection.LAND_WALK);
	}


}
