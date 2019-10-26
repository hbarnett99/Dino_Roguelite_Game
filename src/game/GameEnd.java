package game;

import edu.monash.fit2099.engine.GameMap;

public class GameEnd {
	
	public static void winGamePlayer (Player player) {
		System.out.println("\nCongratulations, you hatched a T-Rex after" + player.getTurns() + " turns and have won.\nThanks for playing!");
        stopRunningGame(player);
	}
	
	public static void loseGame(Player player) {
		System.out.println("\nYou have died and lost the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame(player);
	}
	
	public static void quitGame(Player player) {
        System.out.println("\nYou've quit the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame(player);
	}
	
	private static void stopRunningGame(Player player) {
		System.exit(0);
	}
	
	
	
	//Removes player, stopping the game loop from running
	public static void winGame(Player player, GameMap map) {
		System.out.println("\nCongratulations, you hatched a T-Rex after" + player.getTurns() + " turns and have won.\nThanks for playing!");
        stopRunningGame(player, map);
	}
	
	public static void loseGame(Player player, GameMap map) {
		System.out.println("\nYou have died and lost the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame(player, map);
	}
	
	public static void quitGame(Player player, GameMap map) {
        System.out.println("\nYou've quit the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame(player, map);
	}
	
	private static void stopRunningGame(Player player, GameMap map) {
		map.removeActor(player);
		System.exit(0);
	}
}
