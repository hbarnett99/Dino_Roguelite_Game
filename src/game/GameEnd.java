package game;

import edu.monash.fit2099.engine.GameMap;

	/**
	 * Class to hold static methods that result in the ending of the game and game loop
	 */

public class GameEnd {
	
	/**
	 * Static method called for whenever a win condition is met.
	 */
	public static void winGamePlayer () {
		System.out.println("\nCongratulations, you hatched a T-Rex and have won.\nThanks for playing!");
        stopRunningGame();
	}
	
	/**
	 * Static method called for whenever a loss condition is met.
	 * @param player	The player
	 */
	public static void loseGame(Player player) {
		System.out.println("\nYou have died and lost the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame();
	}
	
	/**
	 * Static method called for when the game is quit by choice.
	 * @param player	The player
	 */
	public static void quitGame(Player player) {
        System.out.println("\nYou've quit the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame();
	}
	
	/**
	 * Exits system and stops it from running
	 * Created so that if the way to physically stop the game occurs, only this method must be changed 
	 */
	private static void stopRunningGame() {
		System.exit(0);
	}
	
	
	
	/**
	 * Static method called for whenever a win condition is met.
	 * @param player	The player
	 * @param map		The current game map
	 */
	public static void winGame(Player player, GameMap map) {
		System.out.println("\nCongratulations, you hatched a T-Rex after" + player.getTurns() + " turns and have won.\nThanks for playing!");
        stopRunningGame(player, map);
	}

	/**
	 * Static method called for whenever a loss condition is met.
	 * @param player	The player
	 * @param map		The current game map
	 */
	public static void loseGame(Player player, GameMap map) {
		System.out.println("\nYou have died and lost the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame(player, map);
	}
	
	/**
	 * Static method called for when the game is quit by choice.
	 * @param player	The player
	 * @param map		The current game map
	 */
	public static void quitGame(Player player, GameMap map) {
        System.out.println("\nYou've quit the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame(player, map);
	}

	/**
	 * Exits system and stops it from running
	 * Map is taken so that the player can be removed from the map, and the GameLoop stops
	 * @param player	The player
	 * @param map		The current game map
	 */
	private static void stopRunningGame(Player player, GameMap map) {
		map.removeActor(player);
		System.exit(0);
	}
}
