package game;

import edu.monash.fit2099.engine.*;
import java.util.ArrayList;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	public ArrayList<Item> inventory = new ArrayList<>();
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
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		
		if (map.locationOf(this).getGround().hasSkill(SkillCollection.SHOP)){
			actions.add(new SellAction());
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
		String walletString = "";
		
		walletString += "$" + String.format("%.2f", (double) wallet);
		
		return walletString;
	}

	
}
