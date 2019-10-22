package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import edu.monash.fit2099.engine.*;

/*
 * Abstract clas to SellAction and BuyAction. Gives an itemCaster method and an input selector
 */

public abstract class SelectAction extends Action {

	public SelectAction() {
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
	
	//Casts an item into a portableDinoItem
	protected static SaleItem itemCaster(Item itemToCast) {
		return (SaleItem) itemToCast;
	}
	
	
	/*Takes a user input as a string, and converts it to an integer
	 * Static to allow other methods (namely BuyAction) to use it.
	 */
    protected String charSelector(String prompt) {
        System.out.print("\n" + prompt+ "\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(true) {
	        try {
	            s = in.readLine();
	            break;
	        } catch (Exception e) {
	            System.out.println("Not a number; Try again");
	        }
        }

        return s;
    }
    
    protected int intSelector(String prompt) {
        System.out.print("\n" + prompt+ "\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int i;
        while(true) {
	        try {
	            s = in.readLine();
	            i = Integer.parseInt(s);
	            break;
	        } catch (Exception e) {
	            System.out.println("Not a number; Try again");
	        }
        }

        return i;
    }

}
