package dungeonCharacters;

import Heroes.Hero;
import Monsters.Monster;

// Abstract class for the factory pattern, which creates the hero and the monster.
public abstract class AbstractFactory {
	public abstract Hero createHero(int choice);
	public abstract Monster createMonster();
	
}
