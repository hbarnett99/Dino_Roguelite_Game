package game;

import edu.monash.fit2099.engine.*;

public class TagDino extends Action {

	public TagDino() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(Player player, Actor dino, ActorLocations dinoLocation, GameMap map) {
		int dinoValue = 0;
		String dinoName = "";
		String executePrint;
		
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
		
		dinoLocation.remove(dino);
		player.addToWallet(dinoValue);
		executePrint = dinoName + " tagged and sold for " + Player.moneyFormat(dinoValue);
		return executePrint;
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		return null;
	}

}
