package game;
import edu.monash.fit2099.engine.*;

public class Corpse extends PortableDinoItem {
	
	private int foodValue;

	public Corpse(String name) {
		super(name, 'c');
		// TODO Auto-generated constructor stub
	}
	
	public int getFoodValue() {
		return foodValue;
	}

}
