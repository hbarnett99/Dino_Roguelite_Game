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

	//actor to be attacked
	protected Actor target;

	public EatAction(Actor target) {
		this.target = target;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "";
		
		if (target.getDisplayChar() != '>') {
			Item corpse = new Corpse("Dead");
			map.locationOf(target).addItem(corpse);
		}
		
		//
		//gain hunger
		if (target.getDisplayChar()!='@') {
			target.asDinosaur().getFoodValue();
		}
		
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
