package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

/**
 * The action for dinosaurs to eat
 */
public class EatAction  extends Action {

	/**
	 * Actor to be attacked
	 */
	protected Actor target;

	public EatAction(Actor target) {
		this.target = target;
	}
	/**
	 * method for Eating the target actor
	 * @return a displayu string saying the target was eaten and who by
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "";
		//Checks if its a fish, fish dont have corpses
		if (target.getDisplayChar() != '>') {
			Item corpse = new Corpse("Dead");
			map.locationOf(target).addItem(corpse);
		}
		
		/**
		 * Casts the actor to dino if its not the player.
		 * This allows us to use the getters and setters in dino
		 */
		if (target.getDisplayChar()!='@') {
			target.asDinosaur().getFoodValue();
		}
		//Drops the actors inventory and removes actor
		Actions dropActions = new Actions();
		for (Item item : target.getInventory())
			dropActions.add(item.getDropAction());
		for (Action drop : dropActions)		
			drop.execute(target, map);
		map.removeActor(target);	
		result += System.lineSeparator() + target + " is eaten by " + actor;
		
		return result;
	}



	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target;
	}

}
