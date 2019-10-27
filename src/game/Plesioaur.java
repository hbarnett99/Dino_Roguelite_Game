package game;
import java.util.ArrayList;
import java.util.List;


import edu.monash.fit2099.engine.*;
import game.CarnivoreFood;

/**
 * Class for the Plesioaur, the water Dino
 */
public class Plesioaur extends Dinosaur {

	/**
	 * @param carnFood variable to hold the type marine food so that the dinos can hunt for it
	 */
	GameMap map;
	public List<Behaviour> actionFactories = new ArrayList<Behaviour>();
	private MarineFood marnFood;
	
	

	public Plesioaur(String name, char displayChar, int hitPoints) {
		super(name, 'F', 200, Egg.DinosaurType.PLESIOSAUR);
		// TODO Auto-generated constructor stub
	}

	public Plesioaur(String name) {
		super(name, 'F', 100, Egg.DinosaurType.PLESIOSAUR);
		hunger = 70;
		hitPoints = 50;
		this.behaviour = new HuntBehaviour("Fish", marnFood, new Corpse("Dead"));
		this.addSkill(SkillCollection.WATER_WALK);
		// TODO Auto-generated constructor stub
	}
}
