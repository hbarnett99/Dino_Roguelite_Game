package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	private int wallet = 0;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		//Shows the players wallet each turn
		System.out.println("Wallet: "+ displayWallet());
		
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		
		//Checks to see if the player is in the shop
		if (map.locationOf(this).getGround().hasSkill(SkillCollection.SHOP)){
			actions.add(new BuyAction());
			actions.add(new SellAction());
		}
		
		//Checks to see if a dino can be tagged
		if (checkForTag() && dinoAdjacent(map)) {
			actions.add(new TagDino());
		}
		
		return menu.showMenu(this, actions, display);
	}
	
	/*
	 * Method that is used to add funds to players wallet when selling items 
	*/
	
	public void addToWallet(int numToAdd) {
		wallet += numToAdd;
	}
	
	/*
	 * Method that is used to take funds to players wallet when buying items
	 * @returns a boolean to see if the player had enough money, if false, the transaction fails
	*/
	
	public boolean takeFromWallet(int numToTake) {
		boolean check = false;
		if (wallet - numToTake >= 0) {
			wallet -= numToTake;
			check = true;
		}
		else {
			System.out.println("Error: Not enough funds!");
		}
		return check;
	}
	
	/*
	 * @returns the amount of money player has in the form of a formatted String
	*/
	
	public String displayWallet() {

		return moneyFormat(wallet);
	}
	
	/*
	 * @return moneyString	a String formatted for currency. Static so other classes with no reference can use it
	 */
	public static String moneyFormat(int value) {
		String moneyString = "";
		
		moneyString += "$" + String.format("%.2f", (double) value);
		
		return moneyString;
	}
	
	/*
	 * @return haveTag 	A boolean to check if the player has a DinoTag in their inventory 
	 */
	private boolean checkForTag() {
		boolean haveTag = false;
		int checkBags = 0;
		while (this.getInventory().size() > checkBags) {
			if (this.getInventory().get(checkBags).hasSkill(SkillCollection.DINO_TAG)) {
				haveTag = true;
			}
			checkBags++;
		}
		return haveTag;
	}
	
	private boolean dinoAdjacent(GameMap map) {
		boolean isAdjacent = false;
		
		if (map.isAnActorAt(map.at(map.locationOf(this).x()+1, map.locationOf(this).y())) ||
			map.isAnActorAt(map.at(map.locationOf(this).x()-1, map.locationOf(this).y())) ||
			map.isAnActorAt(map.at(map.locationOf(this).x(), map.locationOf(this).y()+1)) ||
			map.isAnActorAt(map.at(map.locationOf(this).x(), map.locationOf(this).y()-1)))
		{
			isAdjacent = true;
		}
		
		System.out.println(isAdjacent + "isAdjacent");
		return isAdjacent;
	}

	
}
