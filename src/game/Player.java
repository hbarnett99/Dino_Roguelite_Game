package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	private int wallet = 0;
	private int turnCounter = -1;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		//Allows Actor to walk on Land
		this.addSkill(SkillCollection.LAND_WALK);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turnCounter++;
		
		System.out.println("Inventory:");
		
		if(!displayInventory()) {
			System.out.println("empty");
		}
		//Shows the players wallet each turn
		System.out.println("Wallet: "+ displayWallet());

		actions.add(new QuitAction());
		
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		
		//Checks to see if the player is in the shop
		if (map.locationOf(this).getGround().hasSkill(SkillCollection.SHOP)){
			actions.add(new BuyAction());
			actions.add(new SellAction());
		}
		
		//Checks to see if a dino can be tagged
		if (checkForItem(SkillCollection.DINO_TAG) && dinoAdjacent(map)) {
			actions.add(new TagDino());
		}
				
		//Checks if the user has a boat to allow them to cross water
		if (checkForItem(SkillCollection.WATER_WALK)) {
			this.addSkill(SkillCollection.WATER_WALK);
		}
		else {
			this.removeSkill(SkillCollection.WATER_WALK);
		}

		if (this.hitPoints <= 0) {
			lossByDeath(turnCounter);
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
	private boolean checkForItem(SkillCollection skillOfItem) {
		boolean haveTag = false;
		int checkBags = 0;
		while (this.getInventory().size() > checkBags) {
			if (this.getInventory().get(checkBags).hasSkill(skillOfItem)) {
				haveTag = true;
			}
			checkBags++;
		}
		return haveTag;
	}
	
	private void lossByDeath(int counter) {
		System.out.println("\nYou have died and lost the game after " + counter + " turns.\nThanks for playing!");
		System.exit(0);
	}
	
	/*
	 * @return true if a dino is next to the player
	 */
	private boolean dinoAdjacent(GameMap map) {
		boolean isAdjacent = false;
		
		if (map.isAnActorAt(map.at(map.locationOf(this).x()+1, map.locationOf(this).y())) ||
			map.isAnActorAt(map.at(map.locationOf(this).x()-1, map.locationOf(this).y())) ||
			map.isAnActorAt(map.at(map.locationOf(this).x(), map.locationOf(this).y()+1)) ||
			map.isAnActorAt(map.at(map.locationOf(this).x(), map.locationOf(this).y()-1)))
		{
			isAdjacent = true;
		}

		return isAdjacent;
	}
	
	public int getTurns() {
		return turnCounter;
	}
	
	public boolean displayInventory() {
		boolean check = false;
		
		if(this.getInventory().size() != 0) {
			check = true;
			for (int i = 0; i < this.getInventory().size(); i++) {
				System.out.println(this.getInventory().get(i));
			}
		}
		return check;
	}
	


	
}
