package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * The main class for the dinosaur park game.
 *
 */
public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Shop());
		
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######....................................................................",
		".....#-----#....................................................................",
		".....#-----#....................................................................",
		".....###.###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		".....................................++++++.....................................",
		"......................................+++.......................................",
		".....................................+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);
		
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(8, 4));
		
		Protoceratops proto1 = new Protoceratops("Protoceratops");
		gameMap.at(40, 5).addActor(proto1);
		gameMap.at(32, 12).addActor(new Protoceratops("Protoceratops"));
		
		//adds Velociraptors 
		Velociraptor veloc1 = new Velociraptor("Velociraptor");
		gameMap.at(32, 11).addActor(veloc1);
		veloc1.actionFactories.add(new HuntBehaviour("Proto"));
		//veloc1.actionFactories.add(new WanderBehaviour());
		veloc1.actionFactories.add(new EatBehaviour());
		//gameMap.at(10, 15).addActor(new Velociraptor("Velociraptor"));	
		
		//adds an egg
		
		
		
		world.run();
	}
}
