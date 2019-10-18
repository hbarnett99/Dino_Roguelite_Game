package game;

import edu.monash.fit2099.engine.*;

/*
 * Action that allows the Player to sell at the Shop
 */

public class SellAction extends SelectAction {
	
	protected String hotKey;

	public SellAction() {
		hotKey = "z";
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		int numberOfItemInArray;
		String executeMessage;
		
		//Checks if the player has any items
		if (actor.getInventory().size() == 0) {
			executeMessage = "You have nothing in your Inventory";
		}
		//Shows the players items if they have any
		else {
			for (int i = 0; i < actor.getInventory().size(); i++) {
				System.out.println((i+1) + ": " + actor.getInventory().get(i)+  " - " + Player.moneyFormat(itemCaster(actor.getInventory().get(i)).getSellValue()));
			}
			//Ensures the Player picks a valid option
			while (true) {
				numberOfItemInArray = Integer.parseInt(selector("What item would you like to sell?")) - 1;
				try {
					executeMessage = actor.getInventory().get(numberOfItemInArray) + " was sold for " + Player.moneyFormat(itemCaster(actor.getInventory().get(numberOfItemInArray)).getSellValue());
					break;
				} catch (Exception e) {
					System.out.println("Invalid input: Not an Item");
				}
			}			
			sellToShop(actor.getInventory().get(numberOfItemInArray), actor);
		}

		return executeMessage;
	}

	@Override
	public String menuDescription(Actor actor) {
		String desc = "Sell an item";
		return desc;
	}
	
	//Sells the item to the Shop
	private void sellToShop(Item item, Actor actor) {
		((Player) actor).addToWallet(itemCaster(item).getSellValue());
		actor.removeItemFromInventory(item);
	}


}
