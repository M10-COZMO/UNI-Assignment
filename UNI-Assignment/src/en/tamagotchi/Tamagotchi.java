package en.tamagotchi;

public class Tamagotchi {
	
	private String name;
	private int hungry;
	private int love;
	
	public Tamagotchi(String _name, int _hungry, int _love) {
		this.name = _name;
		this.hungry = _hungry;
		this.love = _love;
	}
	
	public Tamagotchi() {
		
	}

	@Override
	public String toString() {
		return "Tamagotchi [name=" + name + ", hungry=" + hungry + ", ove=" + love + "]";
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

	public int getLove() {
		return love;
	}

	public void setLove(int ove) {
		this.love = ove;
	}
	
	public void giveBisciuts(int numberOfGivenBisciuts) {
		hungry = hungry + numberOfGivenBisciuts;
	}
	
	public void giveHand(int numberOfGivenOve) {
		love = love + numberOfGivenOve;
	}
	
	

}
