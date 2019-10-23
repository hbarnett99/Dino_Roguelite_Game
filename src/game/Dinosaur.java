package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import game.Behaviour;

public class Dinosaur extends Actor {
	public int hunger = 0;
	public int foodValue = 0;
	public Behaviour behaviour;
	public Dinosaur(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		hunger -=1;
		 if (hunger <= 0) {
			return new dieAction();
		}
		 Action action = behaviour.getAction(this, map);
			//Action action = factory.getAction(this, map);
			if(action != null)
				return action;
				System.out.print("actioncalled");
			
			return new DoNothingAction();
	}

	void setHunger(int changeHunger) {
		hunger = changeHunger;
	}
	
	int getHunger() {
		 return hunger;
	}
	int getFoodValue() {
		return foodValue;
	}
	public void increaseHunger(int hungerPoints) {
		hunger += hungerPoints;
	}
}
