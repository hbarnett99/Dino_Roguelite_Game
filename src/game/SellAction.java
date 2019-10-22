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
		String executeMessage = "Your inventory is empty!";
		
		//Checks if the player has any items
		if (displayInventorySell((Player)actor)) {
			//Ensures the Player picks a valid option
			while (true) {
				numberOfItemInArray = intSelector("What item would you like to sell?") - 1;
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
	
	public boolean displayInventorySell(Player player) {
		boolean check = false;
		
		if(player.getInventory().size() != 0) {
			check = true;
			for (int i = 0; i < player.getInventory().size(); i++) {
				System.out.println((i+1) + ": " + player.getInventory().get(i)+  " - " + player.moneyFormat(SelectAction.itemCaster(player.getInventory().get(i)).getSellValue()));
			}
		}
		return check;
	}


}
