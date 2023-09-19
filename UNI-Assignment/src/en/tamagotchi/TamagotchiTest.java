package en.tamagotchi;

public class TamagotchiTest {

	public static void main(String[] args) {
		
		Tamagotchi tama = new Tamagotchi("Pallino", 50, 50);
		
		System.out.println("-- First Test --");
		tama.giveBisciuts(20);
		System.out.println(tama.getHungry());
		System.out.println("Expected: 70");
		
		System.out.println("-- Second Test --");
		tama.giveHand(20);
		System.out.println(tama.getLove());
		System.out.println("Expected: 70");
	}

}
