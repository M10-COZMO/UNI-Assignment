package en.tamagotchi;

public class Tamagotchi {
	
	private String name;
	private int hungry;
	private int affection;
	
	public Tamagotchi(String _name, int _hungry, int _affection) {
		this.name = _name;
		this.hungry = _hungry;
		this.affection = _affection;
	}
	
	public Tamagotchi() {
		
	}

	@Override
	public String toString() {
		return "--------------\n(⌐■_■)\n" + "Name: " + name + "\nHungry: " + hungry + "\nAffection: " + affection;
		//return "Tamagotchi [name: " + name + ", hungry: " + hungry + ", affection: " + affection + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHungry() {
		return hungry;
	}

	public void setHungry(int hungry) {
		this.hungry = hungry;
	}

	public int getAffection() {
		return affection;
	}

	public void setAffection(int affection) {
		this.affection = affection;
	}
	
	public void giveCookies(int numberOfGivenCookies) {
		hungry = hungry + numberOfGivenCookies;
		affection = affection - (numberOfGivenCookies / 2);
	}
	
	public void giveHand(int numberOfGivenCaresses) {
		affection = affection + numberOfGivenCaresses;
		hungry = hungry - (numberOfGivenCaresses / 2);
	}
	
	public Boolean death() {
		if (hungry < 0 || affection < 0) {
			return true;
		} else if (hungry > 100 || affection > 100) {
			return true;
		} else {
			return false;
		}
	}
}
