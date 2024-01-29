package en.tamazoo;

import java.util.Random;

public class GreedyTama extends Tamagotchi{

	private static final int GREEDY = 100;

	public GreedyTama() {
	}

	public GreedyTama(String _name, int _satisfaction, int _satiety) {
		super(_name, _satisfaction, _satiety);
		_satisfaction = GREEDY;
	}

	@Override
	public boolean death() {
		if (getSatiety() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isSad() {
		if (getSatiety() < 30) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	protected void increaseSatisfaction(int nCaressesReceived) {
		int newValue = getSatiety();
		newValue = (newValue - (nCaressesReceived / 2))*2;
		setSatiety(newValue);
	}

	@Override
	public String toString() {
		return "GreedyTama - [Name: " + getName() + " Satiety: " + getSatiety() + "]";

	}
	
	@Override
	public void generateTamaValue() {
		Random random = new Random();
		setSatiety(random.nextInt(100) + 1);
	}	
	
	

	
	
}
