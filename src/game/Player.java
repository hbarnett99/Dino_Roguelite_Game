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
		return menu.showMenu(this, actions, display);
	}
	
	public String displayWallet() {
		String walletString = "";
		
		walletString += "$" + String.format("%.2f", (double) wallet);
		
		return walletString;
	}

}
