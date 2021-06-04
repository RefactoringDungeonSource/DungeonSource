import Heroes.Hero;
import Keyboard.Keyboard;
import Monsters.Monster;
import dungeonCharacters.FactoryProducer;


/* Team 11 -- Trace Wynecoop, Hieu Tran, Erick Vargas, Arthur Wallace, Alex Vanchu	
 * CSCD212
 * Description: Driver file for Heroes and Monsters project.
 * 					
 *		Refactor Project:
 *			History:
 *				-- Created Abstract Factory class. 
 *				-- Created Factory Producer class.
 *				-- Created Hero Factory class.
 *				-- Created Monster Factory class.
 *				-- Refactored names:
 *						-- Heroes:
 *							-- Rogue class previously Theif class.						Side Note: All Heroes
 *							-- Paladin class previously Sorceress class					 and Monsters classes 
 *							-- Hunter class previously Warrior class.					 have been modified to
 *  					-- Monsters:													 fit current theme 
 *							-- BloodOrc class previously Ogre class.					 structure.
 *							-- DecayingWolf class previously Gremlin class
 *							-- Dragon class previously Skeleton class.
 *				
 *				-- hitPoints Variable refactored to Health.
 *				-- blowPoints variable refactored to crushingHitChance.
 *				-- keyboard file refactored: Replacing two deprecated methods for type casting
 *				-- CharacterValues class created: Updating old storage handling for data previously held in dataCharacter
 *				-- Refactored Dungeon file methods:
 *                 chooseHero() - Created a loop to validate user input for the hero selection. 
 *				   Any values not within 1-3 will prompt the user to re-enter the value.
 *                 generateMonster() - Removed case 3 where Dragon object is created. 
 *                 If the random value is not 1 or 2, then it would be 3, which is defaulted to the Dragon object creation.
 *              -- Refactored switch statements.
 *              -- Refactored Paladin class, ensuring limited healing; there by ending exploit of unlimited healing ensuring no death.
 *              -- Refactored visablity of all variables to Private in CharacterValues(). (Using setters and getters)
 *              -- Refactored DungeonCharacter file to ensure getters are used for retrieving character values.
 *              -- Refactored Monster file for same; ensuring getters and used. 
 *              -- Refactored Paladin class setting all variables to private; using getters for variables.
 *              -- Packages created for organization:
 *              		-- (default package): contains Dungeon class
 *              		-- dungeonCharacters: contains AbstractFactory, CharacterValues, DungeonCharacter, FactoryProducer, 
 *              		   					  HeroFactory, and MonsterFactory classes.
 *               		-- Heroes: contains Rogue, Paladin, Hunter, and Hero classes.
 *               		-- Monsters: contains BloodOrc, Dragon, DecayingWolf, and Monster classes.
 *               		-- Keyboard: contains Keyboard class.
 *              -- Refactored Dungeon class; Created the hero object inside the do...while loop instead of outside.  
 *				-- Changed return value of the chooseHero method since we have a factory to produce the hero object.
 *				-- Changed the return value for generateMonster method since e have a factory that can produce a random monster object.
 *				
 *		
 *		Original Dungeon Source:
 *			 Copyright:    Copyright (c) 2001
 * 				Company: Code Dogs Inc.
 * 				I.M. Knurdy
 *
 * 				History:
 *  			11/4/2001: Wrote program
 *    				--created DungeonCharacter class
 *    				--created Hero class
 *    				--created Monster class
 *    				--had Hero battle Monster
 *    				--fixed attack quirks (dead monster can no longer attack)
 *    				--made Hero and Monster abstract
 *    				--created Warrior
 *    				--created Ogre
 *    				--made Warrior and Ogre battle
 *    				--added battleChoices to Hero
 *    				--added special skill to Warrior
 *    				--made Warrior and Ogre battle
 *    				--created Sorceress
 *    				--created Thief
 *    				--created Skeleton
 *    				--created Gremlin
 *    				--added game play features to Dungeon.java (this file)
 *  			11/27/2001: Finished documenting program
 * 				version 1.0
 */



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above
*/
public class Dungeon // Refactoring #9 - Removed Comparable
{
    public static void main(String[] args)
	{

		do
		{
			Hero theHero = chooseHero(); // Refactoring #10 - Moved the object creation into the do...while loop.
		    	Monster theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

    }//end main method

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public static Hero chooseHero()
	{
		int choice = -1;
		boolean answer = true;
		while(answer) {
			System.out.println("Choose a hero:\n" +
						"1. Rogue\n" +
						"2. Paladin\n" +
						"3. Hunter\n"+
						"4. GunSlinger");
			choice = Keyboard.readInt();
			if(choice > 0 && choice < 5) {
				answer = false;
			} else {
				System.out.println("Invalid input. Please enter a value between 1 and 3.");
			}
			
		}
		return FactoryProducer.getFactory("Hero").createHero(choice);
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
the factory pattern to accomplish this.
---------------------------------------------------------------------*/
	public static Monster generateMonster()
	{
		return FactoryProducer.getFactory("Monster").createMonster();
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(theHero.CharacterValues.getName() + " battles " +
							theMonster.CharacterValues.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.readChar();

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.CharacterValues.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.CharacterValues.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method

}//end Dungeon class
