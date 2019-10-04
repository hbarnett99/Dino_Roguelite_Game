package game;

import edu.monash.fit2099.engine.*;

public class TagDino extends Action {

	public TagDino() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Actor player, GameMap map) {
		int dinoValue = 0;
		String dinoName = "";
		String executePrint = "";
		Actor dino = dinoFinder(player, map);
		
		if (dino.toString().equals("Protoceratops")){
			dinoValue = 100;
			dinoName = "Protoceratops";
		}
		else if (dino.toString().equals("Velociraptor")){
			dinoValue = 500;
			dinoName = "Velociraptor";
		}
		else {
			System.out.println("Cannot tag that actor.");
		}
		
		map.removeActor(dino);
		((Player)player).addToWallet(dinoValue);
		executePrint = dinoName + " tagged and sold for " + Player.moneyFormat(dinoValue);
		return executePrint;
	}

	@Override
	public String menuDescription(Actor actor) {
		return "Tag dinosaur";
	}
	
	private Actor dinoFinder(Actor player, GameMap map) {
		Actor actorToReturn;
		
		if (map.isAnActorAt(map.at(map.locationOf(player).x()+1, map.locationOf(player).y()))) {
			actorToReturn = map.getActorAt(map.at(map.locationOf(player).x()+1, map.locationOf(player).y()));
		}
		else if (map.isAnActorAt(map.at(map.locationOf(player).x()-1, map.locationOf(player).y()))) {
			actorToReturn = map.getActorAt(map.at(map.locationOf(player).x()-1, map.locationOf(player).y()));
		}
		else if(map.isAnActorAt(map.at(map.locationOf(player).x(), map.locationOf(player).y()+1))) {
			actorToReturn = map.getActorAt(map.at(map.locationOf(player).x(), map.locationOf(player).y()+1));
		}
//		else if(map.isAnActorAt(map.at(map.locationOf(player).x(), map.locationOf(player).y()-1))) {
//			actorToReturn = map.getActorAt(map.at(map.locationOf(player).x(), map.locationOf(player).y()-1));
//		}
		else {
			actorToReturn = map.getActorAt(map.at(map.locationOf(player).x(), map.locationOf(player).y()-1));
		}
		
		return actorToReturn;
	}

}
