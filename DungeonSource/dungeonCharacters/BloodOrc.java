package dungeonCharacters;

public class BloodOrc extends Monster
{

    public BloodOrc()
	{
		super("Ugor the Cheifton of BloodOrc Clan", 165, 3, .8, .3, 5, 50, 5, 50);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(CharacterValues.getName() + " jabs his kris at " +
							opponent.CharacterValues.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class 