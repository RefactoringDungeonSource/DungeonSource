package dungeonCharacters;

public class FactoryProducer { // Refactoring #1 - Factory Pattern
	public static AbstractFactory getFactory(String herotype) {
		if(herotype.equalsIgnoreCase("Hero")) {
			return new HeroFactory();
		}else {
			return new MonsterFactory();
		}
	}
}
