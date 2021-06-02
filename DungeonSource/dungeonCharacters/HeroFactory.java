package dungeonCharacters;

import Heroes.Hero;
import Heroes.Hunter;
import Heroes.Paladin;
import Heroes.Rogue;
import Monsters.Monster;


public class HeroFactory extends AbstractFactory {
	public Hero createHero(int inputValue) {
		Hero hero = null;
		if(inputValue == 1)
		{
			hero = new Paladin();
		}
		else if(inputValue == 2)
		{
			hero = new Hunter();
		}
		else if(inputValue == 3)
		{
			hero = new Rogue();
		}
		else
		{
			throw new java.lang.IllegalArgumentException();
		}
		return hero;
	}

	
	public Monster createMonster() {
		return null;
	}
}
