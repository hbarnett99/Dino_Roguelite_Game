package game;
import edu.monash.fit2099.engine.*;

public class Egg extends PortableDinoItem{
	
	protected enum DinosaurType {PROTOCERATOPS, VELOCIRAPTOR}
	private int age = 0;
	private DinosaurType dinoType;
	private int foodValue;
	
	public Egg(String name, DinosaurType initType) {
		super(name, 'e');
		dinoType = initType;
	}
	
	public int getFoodValue() {
		return foodValue;
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
}
