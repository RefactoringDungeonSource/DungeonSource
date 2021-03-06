package dungeonCharacters;

import Heroes.Hero;
import Heroes.Hunter;
import Heroes.Paladin;
import Heroes.Rogue;
import Heroes.gunSlinger;
import Monsters.Monster;

// Factory pattern implementation to create Heros.
public class HeroFactory extends AbstractFactory {
	public Hero createHero(int inputValue) {
		Hero hero = null;
		if(inputValue == 1) // Refactoring #11 - Changed from switch to if/else.
		{
			hero = new Rogue();
		}
		else if(inputValue == 2)
		{
			hero = new Paladin();
		}
		else if(inputValue == 3)
		{
			hero = new Hunter();
		}
		//new character gunSlinger by Erick
		else if(inputValue == 4) {	// Refactoring #2, Remove duplication of object creation.
			hero = new gunSlinger(); // Refactoring #17 - Added new Hero gunslinger
		}
		else
		{
			throw new java.lang.IllegalArgumentException();
		}
		return hero;
	}

// Will be implemented within MonsterFactory.java
	public Monster createMonster() {
		return null;
		
	}
}
