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

public class Hunter extends Hero
{

    public Hunter()
	{
		super("Hunteress", 75, 6, .8, 20, 40, .5);



    }//end constructor

	public void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("You pet was successful in his attack!\n" +
					CharacterValues.getName() + " gets an additional turn.");
			numTurns++;
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.CharacterValues.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);


	}//end surpriseAttack method

	@Override
	   public void battleChoices(DungeonCharacter opponent)
		{

			super.battleChoices(opponent);

			do
			{
			    System.out.println("1. Attack Opponent");
			    System.out.println("2. Pet Attack");
			    
			    if(moveSelector() == 1) {
			    	attack(opponent);
			    	
			    }
			    
			    else {
			    	surpriseAttack(opponent);
			    	
			    }
			    
				numTurns--;
				if (numTurns > 0)
				    System.out.println("Number of turns remaining is: " + numTurns);

			} while(numTurns > 0);

	    }//end battleChoices method

	}