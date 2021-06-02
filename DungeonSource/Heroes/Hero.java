package Heroes;

import Keyboard.Keyboard;
import dungeonCharacters.DungeonCharacter;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int health, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHealth(int health)
	  public void battleChoices(DungeonCharacter opponent)
	  public int moveSelector()

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	protected int numTurns;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int health, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, health, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public void readName()
  {
		System.out.print("Enter character name: ");
		CharacterValues.setName(Keyboard.readString());
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtracthealth()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

/*-------------------------------------------------------
subtracthealth checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior

Receives: hit points to subtract
Returns: nothing

This method calls: defend() or base version of method
This method is called by: attack() from base class
---------------------------------------------------------*/
public void subtractHealth(int health)
	{
		if (defend())	
		{
			System.out.println(CharacterValues.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHealth(health);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = CharacterValues.getAttackSpeed()/opponent.CharacterValues.getAttackSpeed();
	
		if (numTurns == 0)
			numTurns++;
	
		System.out.println("Number of turns this round is: " + numTurns);
	    
	}//end battleChoices
	
	/* MoveSelector reads the users input and decides whether they 
	 	are using their primary or special move. 
	 	It is replacing the previous switch. 					*/
	public int moveSelector() {
		
	    System.out.print("Choose an option: ");
		int choice = Keyboard.readInt();
	    
	    if (choice < 3) {
	    	return choice;
	    	
	    }
	    
	    else {
			return 2;
	
	    }
	    
	}

}//end Hero class