package Heroes;
import dungeonCharacters.DungeonCharacter;

public class gunSlinger extends Hero{ // Refactoring #16 - New hero creation

    public gunSlinger() {
	
	
	
		super("GunSlinger", 85, 3, .8, 18, 35, .4);

    }//end constructor
    
    // Gunslingers special move is too shoot with a possibility of missing shots
    // If hero tries to shoot this calculates the probability that it will land.
    
	public void shoot(DungeonCharacter opponent)
	{
		double  shoot= Math.random();
		
		if (shoot <= .4)
		{
			System.out.println("you just shot at!\n" +opponent.CharacterValues.getName() +
					CharacterValues.getName() + " gets a chance to shoot again.");
			numTurns++;
			attack(opponent);
			
		}//end 
		else if (shoot >= .9)
		{
			System.out.println(" reload! " + opponent.CharacterValues.getName() + " dodged " +
								"your bullets!");
		}
		
		else
		    attack(opponent);

	}//end shooting
	

	@Override
	public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);

			do
			{
			    System.out.println("1. Empty the clip on "+ opponent.CharacterValues.getName());
			    System.out.println("2. pistol whip " + opponent.CharacterValues.getName());
			    
			    if(moveSelector() == 2) {
			    	attack(opponent);
			    	
			    }
			    
			    else {
			    	shoot(opponent);	
			    }
			    
				numTurns--;
				if (numTurns > 0)
				    System.out.println("Number of turns remaining is: " + numTurns);

			} while(numTurns > 0);

	}//end battleChoices method

}


