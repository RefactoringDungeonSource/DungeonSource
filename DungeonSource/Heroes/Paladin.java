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
	// Implemented to prevent Paladin from gaining infinite health
	private int timesHealed = 0;

//-----------------------------------------------------------------
	//lowered the health for paladin because he can heal himself
	    public Paladin()
		{
			super("Paladin", 100, 4, .5, 15, 30, .5); // Refactoring #12 - Changed hero health.

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
//2nd and new attack 
	public void backHand(DungeonCharacter opponent) { // Refactoring #13 - Added a new attack.
		System.out.println(CharacterValues.getName() + " back hands " +
				opponent.CharacterValues.getName() + " and then fixes pinky ring:");
super.attack(opponent);
	}
	//-----------------------------------------------------------------
	// Uses moveSelector to determine which attack to call.
	
	@Override
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);

		do
		{
			System.out.println("0. BackHand");
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Health");
		    
		    int move = moveSelector();
		    
		    if(move == 1) {
		    	attack(opponent);
		    	
		    }
		    
		    
		    //lowered the amount of times we can heal because he gets too much health self healing
		    else if (move == 2 && timesHealed < 3) { //Refactoring #14
		    	increaseHealth();
		    	timesHealed++;
		    	
		    }
		    else if (move == 0) {
		    	backHand(opponent);
		    	
		    }
		    
		    
		    else {
		    	//when running out of spells i found it ideal to use his backhand to attack rather than an weapon
		    	System.out.println("You've run out of healing spells! Attacking Instead");
		    	backHand(opponent); // Refactoring #15
		    	
		    }
		    
			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }//end battleChoices method
    
}//end class
