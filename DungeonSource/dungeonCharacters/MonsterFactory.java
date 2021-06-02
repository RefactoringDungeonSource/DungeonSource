package dungeonCharacters;

import Monsters.Monster;
import Heroes.Hero;
import Monsters.BloodOrc;
import Monsters.DecayingWolf;
import Monsters.Dragon;

public class MonsterFactory extends AbstractFactory {
	public Monster createMonster()
	{
		int random = (int)(Math.random() * 3) + 1;

		switch(random)
		{
			case 1: return new BloodOrc();

			case 2: return new DecayingWolf();

			case 3: return new Dragon();

			default: System.out.println("invalid choice, returning Skeleton");
				     return new Dragon();
		}
	}

	@Override
	public Hero createHero(int i) {
		return null;
	}

}