package game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import edu.monash.fit2099.engine.*;

/**
 * Abstract class to SellAction and BuyAction. Gives an input selector
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
	
	
	/**
	 * Takes a user input as a string
     * @param prompt	A string that is displayed to the user to prompt what the input should be
     * @return			the input as a string
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
    
    /**
     * Takes and input and converts it to an integer
     * @param prompt	A string that is displayed to the user to prompt what the input should be
     * @return			the input converted to an integer
     */
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
