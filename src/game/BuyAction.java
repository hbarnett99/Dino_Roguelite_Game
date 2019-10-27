package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.*;
import game.Egg.DinosaurType;

/**
 * Action that allows purchasing at the shop.
 *
 */

public class BuyAction extends SelectAction {
	
	/**
	 * Array of Items that the shop sells
	 */
	ArrayList<SaleItem> shopStock = new ArrayList<>();

	/**
	 * Constructor adds all possible items that can be purchased
	 */
	public BuyAction() {
		shopStock.add(new DinoTag());
		shopStock.add(new Boat());
		shopStock.add(new HerbivoreFood());
		shopStock.add(new CarnivoreFood());
		shopStock.add(new MarineFood());
		shopStock.add(new Egg(DinosaurType.PROTOCERATOPS, false));
		shopStock.add(new Egg(DinosaurType.VELOCIRAPTOR, false));
		shopStock.add(new Egg(DinosaurType.PLESIOSAUR, false));
		shopStock.add(new Egg(DinosaurType.PTERANODON, false));
		shopStock.add(new Egg(DinosaurType.T_REX, false));
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		int numberOfItemInArray;
		String executeMessage = "";
		
		for (int i = 0; i < shopStock.size(); i++) {
			System.out.println((i+1) + ": " + shopStock.get(i).toString() +  " - " + Player.moneyFormat(((SaleItem)shopStock.get(i)).getBuyValue()));
		}
		
		//Keeps on trying until a valid option is chosen
		while (true) {
			numberOfItemInArray = intSelector("What item would you like to sell?") - 1;
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
	
	/**
	 * Removes the money from the players inventory and then adds the item to the players inventory
	 * @param itemToBuy		The item that is going to be purchased
	 * @param player		The player
	 */
	public void buyFromShop(Item itemToBuy, Player player) {
		if(player.takeFromWallet(itemToBuy.asSaleItem().getBuyValue())) {
			player.addItemToInventory(itemToBuy);
		}
	}

}
