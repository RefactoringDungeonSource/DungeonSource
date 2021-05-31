
public class CharacterValues {
	
	private String name;
	public int attackSpeed;
	public double chanceToHit;
	public int damageMin;
	public int damageMax;
	public int hitPoints;
	
	//explicit constructor to initialize instance variables
	public CharacterValues(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax) {

		this.name = name;
		this.hitPoints = hitPoints;
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
	
	public int getHitPoints() {
		return this.hitPoints;
		
	}
	
	public int getAttackSpeed() {
		return this.attackSpeed;
		
	}

}
