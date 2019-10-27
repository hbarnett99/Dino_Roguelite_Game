package game;
import edu.monash.fit2099.engine.*;

/**
 * An egg to be made that can be sold, bought, bred and hatched
 */

public class Egg extends Food{
	
	/**
	 * Enum for the Egg's type, this will determine what the egg will hatch into.
	 */	
	protected enum DinosaurType {PROTOCERATOPS, VELOCIRAPTOR, PLESIOSAUR, PTERANODON, T_REX}
	
	private int age = 0;
	private DinosaurType dinoType;
	private boolean isBred;
	
	/**
	 * Constructor
	 * @param initType	The type of dinosaur inside the egg
	 * @param isBred	Bool true if the egg was bred
	 */
	public Egg(DinosaurType initType, boolean isBred) {
		super("Egg", 'e', FoodType.MEAT, 10, 10, 50);
		dinoType = initType;
		this.isBred = isBred;
		super.name = eggVariant(initType);
	}
	
	@Override
	public void tick(Location location) {
		age++;
		if (age == 30) {
			hatch(location);
		}
		System.out.println("age = " + age);
	}
	
	/**
	 * Hatches the egg if left for 30 turns
	 * If the egg is a T-Rex bred, the game is ended through a Win Condition
	 * @param location	The current location of the egg
	 */
	private void hatch(Location location) {
		if (dinoType == DinosaurType.PROTOCERATOPS) {
			location.addActor(new Protoceratops("Protoceratops"));
		} 
		else if (dinoType == DinosaurType.VELOCIRAPTOR) {
			location.addActor(new Velociraptor("Velociraptor"));
		}
		else if (dinoType == DinosaurType.PLESIOSAUR) {
			location.addActor(new Plesioaur("Plesioaur"));
		}
		else if (dinoType == DinosaurType.PTERANODON) {
			location.addActor(new Pteradon("Pteranodon"));
		}
		else if (dinoType == DinosaurType.T_REX) {
			location.addActor(new Trex("T-Rex"));
			if (this.isBred) {
				GameEnd.winGamePlayer();
			}
		}
		location.removeItem(this);
	}
	
	/**
	 * Changes the egg's variables depending on the DinosaurType given.
	 * @param type		Enum dinosaur type that the egg contains
	 * @return newName	Sets the eggs name based on the DinosaurType
	 */
	private String eggVariant(DinosaurType type) {
		String newName = "";
		
		if(type == DinosaurType.PROTOCERATOPS) {
			newName = "Protoceratops Egg";
			sellValue = 10;
			buyValue = 50;
		}
		else if(type == DinosaurType.VELOCIRAPTOR) {
			newName = "Velociraptor Egg";
			sellValue = 200;
			buyValue = 1000;
		}				
		else if(type == DinosaurType.PLESIOSAUR) {
			newName = "Pleasiosaur Egg";
			sellValue = 400;
			buyValue = 2000;
		}		
		else if(type == DinosaurType.PTERANODON) {
			newName = "Pteranodon Egg";
			sellValue = 400;
			buyValue = 2000;
		}		
		else if(type == DinosaurType.T_REX) {
			newName = "T-Rex Egg";
			sellValue = 10000;
			buyValue = 20000;
		}
		
		return newName;
	}
}
