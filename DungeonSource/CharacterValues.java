
public class CharacterValues {
	
	private String name;
	private int attackSpeed;
	private double chanceToHit;
	private int damageMin;
	private int damageMax;
	private int health;
	
	//explicit constructor to initialize instance variables
	public CharacterValues(String name, int health, int attackSpeed, double chanceToHit, int damageMin, int damageMax) {

		this.name = name;
		this.health = health;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

		}
	
	public String getName() {
		return this.name;
	}

	public void setName(String readString) {
		this.name = readString;
		
	}
	
	public int getHealth() {
		return this.health;
		
	}
	
	public void setHealth(int health) {
		this.health = health;
		
	}
	
	public int getAttackSpeed() {
		return this.attackSpeed;
		
	}
	
	public double getChanceToHit() {
		return chanceToHit;
	}

	public void setChanceToHit(double chanceToHit) {
		this.chanceToHit = chanceToHit;
	}

	public int getDamageMax() {
		return damageMax;
	}

	public void setDamageMax(int damageMax) {
		this.damageMax = damageMax;
	}

	public int getDamageMin() {
		return damageMin;
	}

	public void setDamageMin(int damageMin) {
		this.damageMin = damageMin;
	}

}
