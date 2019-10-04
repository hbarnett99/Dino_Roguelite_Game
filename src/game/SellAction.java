package game;

import edu.monash.fit2099.engine.Action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class SellAction extends Action {
	
	protected String hotKey;

	public SellAction() {
		hotKey = "z";
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		
		int numberOfItemInArray;
		String executeMessage;
		
		for (int i = 0; i < actor.getInventory().size(); i++) {
			System.out.println(i + ": " + actor.getInventory().get(i));
		}
		
		numberOfItemInArray = selector("What item would you like to sell?");
		
		executeMessage = actor.getInventory().get(numberOfItemInArray) + " was sold for " + Player.moneyFormat(itemCaster(actor.getInventory().get(numberOfItemInArray)).getItemValue());
				
		sellToShop(actor.getInventory().get(numberOfItemInArray), actor);
		
		return executeMessage;
	}

	@Override
	public String menuDescription(Actor actor) {
		String desc = "Sell Item";
		return desc;
	}
	
	private void sellToShop(Item item, Actor actor) {
		((Player) actor).addToWallet(itemCaster(item).getItemValue());
		actor.removeItemFromInventory(item);
	}
	
	private PortableDinoItem itemCaster(Item itemToCast) {
		return (PortableDinoItem) itemToCast;
	}
	
	
	/*Takes a user input as a string, and converts it to an integer
	 * Static to allow other methods (namely BuyAction) to use it.
	 */
    public static int selector(String prompt) {
        System.out.print("\n" + prompt+ "\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        int i;
        try {
            s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        i = Integer.parseInt(s);

        return i;
    }

}
