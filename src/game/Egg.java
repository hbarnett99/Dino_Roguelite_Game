package game;
import edu.monash.fit2099.engine.*;

/*
 * An egg to be made that can be sold, bought, bred and hatched
 */

public class Egg extends Food{
	
	protected enum DinosaurType {PROTOCERATOPS, VELOCIRAPTOR}
	
	private int age = 0;
	private DinosaurType dinoType;
	
	public Egg(DinosaurType initType) {
		super("Egg", 'e', FoodType.MEAT, 10, 10, 50);
		dinoType = initType;
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
	
	//Hatches the egg if left for 30 turns
	private void hatch(Location location) {
		if (dinoType == DinosaurType.PROTOCERATOPS) {
			location.addActor(new Protoceratops("Protoceratops"));
		} 
		else if (dinoType == DinosaurType.VELOCIRAPTOR) {
			location.addActor(new Velociraptor("Velociraptor"));
		}
		location.removeItem(this);
	}
	
	//Changes the egg's variables depending on the DinosaurType given.
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
		
		return newName;
	}
}
