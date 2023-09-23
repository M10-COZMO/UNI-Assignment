package en.tamagotchi;

public class TamagotchiTest {

	public static void main(String[] args) {
		
		System.out.println("-- First Test --");
		Tamagotchi t1 = new Tamagotchi("Pallino", 50, 50);
		t1.giveCookies(20);
		System.out.println(t1.getHungry());
		System.out.println("Expected: 70");
		
		System.out.println("-- Second Test --");
		Tamagotchi t2 = new Tamagotchi("Pallino", 50, 50);
		t2.giveCaresses(20);
		System.out.println(t2.getAffection());
		System.out.println("Expected: 70");
		
		System.out.println("-- Third Test --");
		Tamagotchi t3 = new Tamagotchi("Pallino", 20, 50);
		t3.giveCaresses(40);
		System.out.println(t3.death());
		System.out.println("Expected: true");
		
		System.out.println("-- FourthTest --");
		Tamagotchi t4 = new Tamagotchi("Pallino", 50, 20);
		t4.giveCookies(40);
		System.out.println(t4.death());
		System.out.println("Expected: true");
	}

}
