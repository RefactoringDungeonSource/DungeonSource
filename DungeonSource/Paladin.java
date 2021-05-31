

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Paladin extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------

	    public Paladin()
		{

			super("Paladin", 175, 4, .5, 15, 30, .5);


	    }//end constructor

//-----------------------------------------------------------------
	public void increaseHealth()
    {
	    int health;

	    health = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addhealth(health);
		System.out.println(CharacterValues.getName() + " added [" + health + "] points.\n"
							+ "Total hit points remaining are: "
							+ CharacterValues.health);
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(CharacterValues.getName() + " casts holy light at " +
							opponent.CharacterValues.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Health");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: increaseHealth();
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		    if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && CharacterValues.health > 0 && opponent.CharacterValues.getHealth() > 0);

    }//end overridden method

}//end class