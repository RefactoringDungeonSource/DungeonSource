package dungeonCharacters;

import Monsters.Monster;
import Heroes.Hero;
import Monsters.BloodOrc;
import Monsters.DecayingWolf;
import Monsters.Dragon;


// Implements the MonsterFactory to create Monsters using the factory pattern
public class MonsterFactory extends AbstractFactory {
	public Monster createMonster()
	{
		int random = (int)(Math.random() * 3) + 1;

		switch(random)
		{
			case 1: return new BloodOrc();

			case 2: return new DecayingWolf();	// Refactoring #2, Remove duplication of object creation.
			
			default: 
				return new Dragon();
		}
	}
	
	// See HeroFactory for implementation
	@Override
	public Hero createHero(int i) {
		return null;
	}

}
