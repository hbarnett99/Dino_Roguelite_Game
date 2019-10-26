package game;

import edu.monash.fit2099.engine.*;

/**
 * Action that allows the Player to sell at the Shop
 */
public class SellAction extends SelectAction {

	/**
	 * Constructor
	 */
	public SellAction() {
		
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		int numberOfItemInArray;
		String executeMessage = "Your inventory is empty!";
		
		//Checks if the player has any items
		if (displayInventorySell(actor.asPlayer())) {
			//Ensures the Player picks a valid option
			while (true) {
				numberOfItemInArray = intSelector("What item would you like to sell?") - 1;
				try {
					executeMessage = actor.getInventory().get(numberOfItemInArray) + " was sold for " + Player.moneyFormat(actor.getInventory().get(numberOfItemInArray).asSaleItem().getSellValue());
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
	
	/**
	 * Sells the item to the Shop
	 * @param item		The item to sell
	 * @param actor		The actor to take the item from, and give the money to
	 */
	private void sellToShop(Item item, Actor actor) {
		actor.asPlayer().addToWallet(item.asSaleItem().getSellValue());
		actor.removeItemFromInventory(item);
	}
	
	/**
	 * Prints out the player's inventory if they have anything in it
	 * Each item prints the number in the array (+1 for logic), and its sell value
	 * @param player	The player
	 * @return check 	Bool returns true if the player has something in their inventory
	 */
	public boolean displayInventorySell(Player player) {
		boolean check = false;
		
		if(player.getInventory().size() != 0) {
			check = true;
			for (int i = 0; i < player.getInventory().size(); i++) {
				System.out.println((i+1) + ": " + player.getInventory().get(i)+  " - " + Player.moneyFormat(player.getInventory().get(i).asSaleItem().getSellValue()));
			}
		}
		return check;
	}


}
