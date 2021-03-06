package Monsters;

import dungeonCharacters.DungeonCharacter;

// New monster class DecayingWolf
public class DecayingWolf extends Monster
{

    public DecayingWolf()
	{
		super("Fang the decaying wolf", 100, 3, .8, .3, 30, 50, 30, 50);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(CharacterValues.getName() + " bites with his decaying mouth at " +
							opponent.CharacterValues.getName() + ":");
		super.attack(opponent);

	}//end override of attack

}//end class DecayingWolf
