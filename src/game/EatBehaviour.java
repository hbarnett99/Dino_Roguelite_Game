package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.NumberRange;

public class EatBehaviour extends Action implements Behaviour {
	private Actor target;
	
	public EatBehaviour() {
		
	}
	@Override
	public Action getAction(Actor actor, GameMap map) {
		outerloop:
			for (int i = 0; i < map.getXRange().max(); i++) {
				for (int k = 0; k < map.getYRange().max(); k++) {
					if (map.isAnActorAt(map.at(i, k))) {
						if (map.at(i, k).getActor().toString().contains("Proto")) {
							target = map.getActorAt(map.at(i, k));
							break outerloop;
						}						
					}					
				}
			}
	
	Location here = map.locationOf(actor);
	Location there = map.locationOf(target);

	if(there !=null) {
		if (distance(here ,there) <3) {
			return new EatAction(target);
		}
	}
	return null;
	}
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String execute(Actor actor, GameMap map) {
		Item corpse = new Corpse("Dead");
		map.locationOf(target).addItem(corpse);
		
		Actions dropActions = new Actions();
		for (Item item : target.getInventory())
			dropActions.add(item.getDropAction());
		for (Action drop : dropActions)		
			drop.execute(target, map);
		map.removeActor(target);
		
		return actor + " eats " + target + "." + System.lineSeparator()+
				target + " is dead.";
	}
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}
