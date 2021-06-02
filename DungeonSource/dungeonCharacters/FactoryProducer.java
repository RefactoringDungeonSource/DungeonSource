package dungeonCharacters;

public class FactoryProducer {
	public static AbstractFactory getFactory(String herotype) {
		if(herotype.equalsIgnoreCase("Hero")) {
			return new HeroFactory();
		}else {
			return new MonsterFactory();
		}
	}
}
