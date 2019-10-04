package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;
import game.Egg.DinosaurType;

/**
 * Action that allows purchasing at the shop.
 *
 */

public class BuyAction extends ShopAction {
	
	ArrayList<PortableDinoItem> shopStock = new ArrayList<PortableDinoItem>();

	public BuyAction() {
		shopStock.add(new HerbivoreFood());
		shopStock.add(new CarnivoreFood());
		shopStock.add(new DinoTag());
		shopStock.add(new Egg(DinosaurType.PROTOCERATOPS));
		shopStock.add(new Egg(DinosaurType.VELOCIRAPTOR));
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		int numberOfItemInArray;
		String executeMessage = "";
		
		for (int i = 0; i < shopStock.size(); i++) {
			System.out.println((i+1) + ": " + shopStock.get(i).toString() +  " - " + Player.moneyFormat(shopStock.get(i).getBuyValue()));
		}
		
		while (true) {
			numberOfItemInArray = selector("What item would you like to buy?");
			try {		
				buyFromShop(shopStock.get(numberOfItemInArray), (Player) actor);
				break;
			} catch (Exception e) {
				System.out.println("Invalid input: Not an Item");
			}
		}

		return executeMessage;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return "Buy an item";
	}
	
	public void buyFromShop(Item itemToBuy, Player player) {
		if(player.takeFromWallet(itemCaster(itemToBuy).getBuyValue())) {
			player.addItemToInventory(itemToBuy);
		}
	}

}
