package en.tamagotchi;

import java.util.Scanner;

public class Main {
	
	private static final String INSERT_LOVE = "Insert initial level of love: ";
	private static final String INSERT_HUNGRY = "Insert initial level of hungry: ";
	private static final String INSERT_NAME = "Insert name: ";

	public static void menu() {
		
	}
	
	public static void generateTamagotchi(Tamagotchi tamagotchi) {
		String name;
		int hungry, love;
		Scanner in = new Scanner(System.in);
		
		System.out.println(INSERT_NAME);
		name = in.next();
		tamagotchi.setName(name);
		
		System.out.println(INSERT_HUNGRY);
		hungry =in.nextInt();
		tamagotchi.setHungry(hungry);
		
		System.out.println(INSERT_LOVE);
		love = in.nextInt();
		tamagotchi.setLove(love);
	}

	public static void main(String[] args) {
		
		Tamagotchi tama = new Tamagotchi();
		generateTamagotchi(tama);
		System.out.println(tama.toString());
	}

}
