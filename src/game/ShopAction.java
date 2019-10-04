package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public abstract class ShopAction extends Action {

	public ShopAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected PortableDinoItem itemCaster(Item itemToCast) {
		return (PortableDinoItem) itemToCast;
	}
	
	
	/*Takes a user input as a string, and converts it to an integer
	 * Static to allow other methods (namely BuyAction) to use it.
	 */
    protected int selector(String prompt) {
        System.out.print("\n" + prompt+ "\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        int i;
        while(true) {
	        try {
	            s = in.readLine();
	            i = Integer.parseInt(s) - 1;
	            break;
	        } catch (Exception e) {
	            System.out.println("Not a number; Try again");
	        }
        }

        return i;
    }

}
