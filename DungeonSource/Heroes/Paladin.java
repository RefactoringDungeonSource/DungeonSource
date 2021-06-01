package Heroes;

import dungeonCharacters.DungeonCharacter;

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
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	private int timesHealed = 0;

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
							+ CharacterValues.getHealth());
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

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Health");
		    int move = moveSelector();
		    
		    if(move == 1) {
		    	attack(opponent);
		    	
		    }
		    
		    
		    else if (move == 2 && timesHealed < 4) {
		    	increaseHealth();
		    	timesHealed++;
		    	
		    }
		    
		    
		    else {
		    	System.out.println("You've run out of healing spells! Attacking Instead");
		    	attack(opponent);
		    	
		    }
		    
			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }//end battleChoices method
    
}//end class
