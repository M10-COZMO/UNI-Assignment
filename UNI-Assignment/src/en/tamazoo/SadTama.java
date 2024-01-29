package en.tamazoo;

import java.util.Random;

public class SadTama extends Tamagotchi{

	private static final int SAD = 0;

	public SadTama() {
	}

	public SadTama(String _name, int _satisfaction, int _satiety) {
		super(_name, _satisfaction, _satiety);
		_satisfaction = SAD;
	}

	@Override
	public boolean death() {
		if (getSatiety() > 90 || getSatiety() < 30) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "SadTama - [Name: " + getName() + " Satiety: " + getSatiety() + "]";
	}
	
	@Override
	public void generateTamaValue() {
		Random random = new Random();
		setSatiety(random.nextInt(100) + 1);
	}	
}
