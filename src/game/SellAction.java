package game;

import edu.monash.fit2099.engine.Action;
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
		sellToShop(actor.getInventory().get(1), actor);
		return null;
	}

	@Override
	public String menuDescription(Actor actor) {
		String desc = "Sell Item";
		return desc;
	}
	
	public void sellToShop(Item item, Actor actor) {
		((Player) actor).addToWallet(((PortableDinoItem) item).getItemValue());
		actor.removeItemFromInventory(item);
	}

}
