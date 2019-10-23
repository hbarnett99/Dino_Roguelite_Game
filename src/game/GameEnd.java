package game;

public class GameEnd {
	
	public static void winGame(Player player) {
		System.out.println("\nCongratulations, you hatched a T-Rex after" + player.getTurns() + " turns and have won.\nThanks for playing!");
		stopRunningGame();
	}
	
	public static void loseGame(Player player) {
		System.out.println("\nYou have died and lost the game after " + player.getTurns() + " turns.\nThanks for playing!");
		stopRunningGame();
	}
	
	public static void quitGame(Player player) {
        System.out.println("\nYou've quit the game after " + player.getTurns() + " turns.\nThanks for playing!");
        stopRunningGame();
	}
	
	private static void stopRunningGame() {
		System.exit(0);
	}
	
}
