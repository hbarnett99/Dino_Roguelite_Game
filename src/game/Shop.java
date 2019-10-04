package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;
import game.Egg.DinosaurType;


 /*
 * A class that extends ground. If a Player is standing on it, gives access to the Shop skill
 */
public class Shop extends Ground{

	ArrayList<Item> shopStock = new ArrayList<Item>();
	
	public Shop() {
		super('-');
		addSkill(SkillCollection.SHOP);
		
		shopStock.add(new Egg(DinosaurType.PROTOCERATOPS));
		shopStock.add(new Egg(DinosaurType.VELOCIRAPTOR));
		shopStock.add(new HerbivoreFood());
		shopStock.add(new CarnivoreFood());
		shopStock.add(new DinoTag());

	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);
	}
	
	public void buyFromShop(PortableDinoItem itemToBuy, Player player) {
		if(player.takeFromWallet(itemToBuy.getItemValue())) {
			player.addItemToInventory(itemToBuy);
		}
	}
	
}
