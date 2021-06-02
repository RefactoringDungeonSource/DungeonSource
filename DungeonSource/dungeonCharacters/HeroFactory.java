package dungeonCharacters;

import Heroes.Hero;
import Heroes.Hunter;
import Heroes.Paladin;
import Heroes.Rogue;
import Monsters.Monster;

// Factory pattern implementation to create Heros.
public class HeroFactory extends AbstractFactory {
	public Hero createHero(int inputValue) {
		Hero hero = null;
		if(inputValue == 1)
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
