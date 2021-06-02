package dungeonCharacters;

import Heroes.Hero;
import Monsters.Monster;

public abstract class AbstractFactory {
	public abstract Hero createHero(int choice);
	public abstract Monster createMonster();
}
