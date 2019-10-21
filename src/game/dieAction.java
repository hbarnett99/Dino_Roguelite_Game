package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class dieAction extends Action {

	@Override
	public String execute(Actor actor, GameMap map) {
		
		String result = "";
		
		
		Item corpse = new Corpse("Dead");
		map.locationOf(actor).addItem(corpse);
		
		Actions dropActions = new Actions();
		for (Item item : actor.getInventory())
			dropActions.add(item.getDropAction());
		for (Action drop : dropActions)		
			drop.execute(actor, map);
		map.removeActor(actor);	
		result += System.lineSeparator() + actor + " has died of starvation ";
		
		return result;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

}
