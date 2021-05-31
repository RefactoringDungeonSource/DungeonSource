

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Monster extends DungeonCharacter
{
	protected double chanceToHeal;
	protected int minHeal, maxHeal;
	
//-----------------------------------------------------------------
  public Monster(String name, int health, int attackSpeed,
				     double chanceToHit, double chanceToHeal,
					 int damageMin, int damageMax,
					 int minHeal, int maxHeal)
  {
	super(name, health, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToHeal = chanceToHeal;
	this.maxHeal = maxHeal;
	this.minHeal = minHeal;

  }//end monster constructor

//-----------------------------------------------------------------
  public void heal()
  {
	boolean canHeal;
	int healingPoints;

	canHeal = (Math.random() <= chanceToHeal) && (CharacterValues.health > 0);

	if (canHeal)
	{
		healingPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		addhealth(healingPoints);
		System.out.println(CharacterValues.getName() + " healed itself for " + healingPoints + " points.\n"
							+ "Total hit points remaining are: " + CharacterValues.health);
		System.out.println();
	}//end can heal


  }//end heal method

//-----------------------------------------------------------------
 public void subtractHealth(int health)
 {
		super.subtractHealth(health);
		heal();

 }//end method


}//end Monster class