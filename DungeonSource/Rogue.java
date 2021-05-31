

public class Rogue extends Hero
{

    public Rogue()
	{

		super("Rogue", 125, 4, .8, 35, 60, .2);


    }//end constructor


	public void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int crushingBlowChance = (int)(Math.random() * 76) + 100;
			System.out.println(CharacterValues.getName() + " lands a thrusting stab for " + crushingBlowChance
								+ " damage!");
			opponent.subtractHealth(crushingBlowChance);
		}//end blow succeeded
		else
		{
			System.out.println(CharacterValues.getName() + " failed to land a blow ");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(CharacterValues.getName() + " swipes with dagger at  " +
							opponent.CharacterValues.getName() + ":");
		super.attack(opponent);
	}//end override of attack method




    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Thrusting Stab");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: crushingBlow(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }//end battleChoices method

}//end Hero class