package en.tamazoo;

import java.util.Random;

public class Tamagotchi {
	
	private String name;
	private int satisfaction;
	private int satiety;
	
	public Tamagotchi(String name, int satisfaction, int satiety) {
		this.name = name;
		this.satisfaction = satisfaction;
		this.satiety = satiety;
	}
	
	// ======================
	// Getters and Setters
	// ======================
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}
	public int getSatiety() {
		return satiety;
	}
	public void setSatiety(int satiety) {
		this.satiety = satiety;
	}
	
	// ======================
	// Useful Methods
	// ======================
	public void increaseSatisfaction(int nCaressesReceived) {
		satisfaction += nCaressesReceived;
		satiety = satiety - (nCaressesReceived / 2);
	}
	
	public void increaseSatiety(int nCookiesReceived) {
		for (int i = 0; i < nCookiesReceived; i++) {
			satiety += (satiety * 10)/100;
		}
		satisfaction = satisfaction - (nCookiesReceived/4);
	}
	
	public void generateTamaValue() {
		Random random = new Random();
		satisfaction = random.nextInt(100) + 1;
		satiety = random.nextInt(100) + 1;
	}
	
	public void generateTamagotchi() {
		generateTamaValue();
	}

}
