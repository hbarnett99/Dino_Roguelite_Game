package game;

import edu.monash.fit2099.engine.*;


/**
 * A class that is supposed .
 */
public class Shop extends Ground{

	public Shop() {
		super('-');
		addSkill(SkillCollection.SHOP);
	}
	
	@Override
	public void tick(Location location) {
		super.tick(location);		
	}
	
	public void sellToShop(PortableDinoItem itemToSell, Player player) {
	//	player.addToWallet(itemToSell.getItemValue());
		player.removeItemFromInventory(itemToSell);
	}
}
