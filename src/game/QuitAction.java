package game;

import edu.monash.fit2099.engine.*;

public class QuitAction extends SelectAction{

    public void QuitAction(){

    }

    public String execute(Actor actor, GameMap map){
        String choice;

        while (true) {
            try {
                choice = selector("Are you sure you want to quit the game?\nPress Y to quit, or any other key to continue playing");
                if (choice.equalsIgnoreCase("y")){
                    System.out.println("\nYou've quit the game\nThanks for playing!");
                    System.exit(0);
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid Option");
            }
        }

        return "You did not quit the game";
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    public String menuDescription(Actor actor){
        return "Quit Game";
    }

}