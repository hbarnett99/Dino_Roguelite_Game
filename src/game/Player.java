package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	
	/**
	 * The amount of money the player has
	 */
	private int wallet;
	
	/**
	 * Counts the number of turns
	 */
	private int turnCounter;
	
	/**
	 * Checks if the player is alive before processing the players actions
	 */
	private boolean isAlive;

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
		wallet = 0;
		turnCounter = -1;
		isAlive = true;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turnCounter++;
		
		//Function call to show inventory
		displayInventory();
		
		//Shows the players wallet each turn
		System.out.println("Wallet: "+ displayWallet());
		
		//this.hitPoints -= 20;

		//Stops game if Players HP = 0
		if (this.hitPoints <= 0) {
			GameEnd.loseGame(this, map);
			isAlive = false;
		}
		
		//Checks to see if the player is in the shop
		if(isAlive) {
			//Adds quit action each turn
			actions.add(new QuitAction());
			
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
		}
		
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		
		return menu.showMenu(this, actions, display);
	}
	
	/**
	 * Method that is used to add funds to players wallet when selling items 
	 * @param numToAdd		The amount of money to be added to the players wallet (Dino value / Item value)
	*/
	public void addToWallet(int numToAdd) {
		wallet += numToAdd;
	}
	
	/**
	 * Method that is used to take funds to players wallet when buying items
	 * @param numToTake		The item's value
	 * @return check		Boolean to see if the player had enough money, if false, the transaction fails
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
	
	/**
	 * @return moneyFormatted	The amount of money player has in the form of a formatted String
	*/
	public String displayWallet() {
		return moneyFormat(wallet);
	}
	
	/**
	 * @param value			The amount of money being parsed in as an integer
	 * @return moneyString	S String formatted for currency. Static so other classes with no reference can use it
	 */
	public static String moneyFormat(int value) {
		String moneyString = "";
		
		moneyString += "$" + String.format("%.2f", (double) value);
		
		return moneyString;
	}
	
	/**
	 * @param skillOfItem	Enum of a skill given to an item
	 * @return haveTag 		A boolean to check if the player has a DinoTag in their inventory 
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
	
	/**
	 * @param map			Current map
	 * @return isAdjacent	True if a dino is next to the player
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
	
	/**
	 * @return turnCounter - Used when a game stops
	 */
	public int getTurns() {
		return turnCounter;
	}
	
	/**
	 * @return boolean for if the players inventory has something in it. 
	 * If if does have something, it prints it as a list
	 */
	public boolean displayInventory() {
		boolean check = false;
		
		if(this.getInventory().size() != 0) {
			check = true;
			System.out.println("Inventory:");
			for (int i = 0; i < this.getInventory().size(); i++) {
				System.out.println(this.getInventory().get(i));
			}
		}
		return check;
	}
}
