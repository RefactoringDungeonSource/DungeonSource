package dungeonCharacters;
/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a
 *              role playing game
 *
 *  class variables (all will be directly accessible from derived classes):
 *    name (name of character)
 *    health (points of damage a character can take before killed)
 *    attackSpeed (how fast the character can attack)
 *    chanceToHit (chance an attack will strike the opponent)
 *    damageMin, damageMax (range of damage the character can inflict on
 *     opponent)
 *
 *  class methods (all are directly accessible by derived classes):
 *    DungeonCharacter(String name, int health, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	  public String getName()
	  public int gethealth()
	  public int getAttackSpeed()
	  public void addhealth(int health)
	  public void subtracthealth(int health) -- this method will be
	    overridden
	  public boolean isAlive()
	  public void attack(DungeonCharacter opponent) -- this method will be
	    overridden
 *
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter
{
	
	public CharacterValues CharacterValues;

//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	public DungeonCharacter(String name, int health, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	{
		
		CharacterValues = new CharacterValues(name, health, attackSpeed, chanceToHit, damageMin, damageMax);

	}//end constructor


/*-------------------------------------------------------
addhealth is used to increment the health a dungeon character has

Receives: number of hit points to add
Returns: nothing

This method calls: nothing
This method is called by: heal method of monsters and Sorceress
---------------------------------------------------------*/
	public void addhealth(int health)
	{
		if (health <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			CharacterValues.setHealth(CharacterValues.getHealth() + health);
			//System.out.println("Remaining Hit Points: " + health);

		}
	}//end addhealth method

/*-------------------------------------------------------
subtracthealth is used to decrement the health a dungeon character has.
It also reports the damage and remaining hit points (these things could be
done in separate methods to make code more modular ;-)

Receives: number of hit points to subtract
Returns: nothing

This method calls: nothing
This method is called by: overridden versions in Hero and Monster
---------------------------------------------------------*/
	public void subtractHealth(int health)
	{
		if (health <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (health >0)
		{
			CharacterValues.setHealth(CharacterValues.getHealth() - health);
			if (CharacterValues.getHealth() < 0)
				CharacterValues.setHealth(0);
			System.out.println(CharacterValues.getName() + " hit " +
								" for <" + health + "> points damage.");
			System.out.println(CharacterValues.getName() + " now has " +
							CharacterValues.getHealth() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (CharacterValues.getHealth() == 0)
			System.out.println(CharacterValues.getName() + " has been killed :-(");

	}//end method

/*-------------------------------------------------------
isAlive is used to see if a character is still alive by checking hit points

Receives: nothing
Returns: true is hero is alive, false otherwise

This method calls: nothing
This method is called by: unknown (intended for external use)
---------------------------------------------------------*/
    public boolean isAlive()
	{
	  return (CharacterValues.getHealth() > 0);
	}//end isAlive method

/*-------------------------------------------------------
attack allows character to attempt attack on opponent.  First, chance to hit
is considered.  If a hit can occur, then the damage is calculated based on
character's damage range.  This damage is then applied to the opponenet.

Receives: opponent being attacked
Returns: nothing

This method calls: Math.random(), subtracthealth()
This method is called by: overridden versions of the method in monster and
hero classes and externally
---------------------------------------------------------*/
	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= CharacterValues.getChanceToHit();

		if (canAttack)
		{
			damage = (int)(Math.random() * (CharacterValues.getDamageMax() - CharacterValues.getDamageMin() + 1))
						+ CharacterValues.getDamageMin() ;
			opponent.subtractHealth(damage);



			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(CharacterValues.getName() + "'s attack on " + opponent.CharacterValues.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method

//-----------------------------------------------------------------

}//end class Character
