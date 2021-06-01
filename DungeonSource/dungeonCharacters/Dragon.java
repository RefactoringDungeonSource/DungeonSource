package dungeonCharacters;

/*
 * monster choice addition of the dragon class.
 */

public class Dragon extends Monster
{

    public Dragon()
	{
		super("Draco the Dragon", 500, 4, .6, .1, 30, 75, 30, 50); 


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(CharacterValues.getName() + " breathes fire at " +
							opponent.CharacterValues.getName() + ":");
		super.attack(opponent);

	}//end override of attack
}//end Monster class