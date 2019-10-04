package game;
import edu.monash.fit2099.engine.*;

public class Egg extends Food{
	
	protected enum DinosaurType {PROTOCERATOPS, VELOCIRAPTOR}
	
	private int age = 0;
	private int sellValue = 10;
	private DinosaurType dinoType;
	
	public Egg(DinosaurType initType) {
		super("Egg", 'e', FoodType.MEAT, 10, 10);
		dinoType = initType;
		super.name = nameEgg(initType);
	}
	
	@Override
	public void tick(Location location) {
		age++;
		if (age == 30) {
			hatch(location);
		}
		System.out.println("age = " + age);
	}
	
	private void hatch(Location location) {
		if (dinoType == DinosaurType.PROTOCERATOPS) {
			location.addActor(new Protoceratops("Protoceratops"));
		} 
		else if (dinoType == DinosaurType.VELOCIRAPTOR) {
			//location.addActor(new Velociraptor("Velociraptor"));
		}
		location.removeItem(this);
	}
	
	private String nameEgg(DinosaurType type) {
		String newName = "";
		
		if(type == DinosaurType.PROTOCERATOPS) {
			newName = "Protoceratops Egg";
		}
		else if(type == DinosaurType.VELOCIRAPTOR) {
			newName = "Velociraptor Egg";
		}
		
		return newName;
	}
	
	public int getSellValue() {
		return sellValue;
	}
}
