package en.tamazoo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import en.tamagotchi.Menu;

public class Main {

	private static final String HOW_MANY_TAMA = "How many tamagotchi do you want?";
	private static final String GREETINGS = "Welcome to TamaZoo!";
	private static final String MENU_TITLE = "Chose one of the following actions";
	private static final String MENU_EXIT = "Exit";
	private static final String MENU_GIVE_COOKIES = "Give Cookies";
	private static final String MENU_GIVE_CARESSES = "Give Caresses";
	private static final String VALUE_TO_HIGH_OR_TO_LOW = "You must enter a number between 20 and 50";
	
	public static Tamagotchi generateTamagotchi(String tamaName) {
		
		Random random = new Random();
		
		int randomNumber = random.nextInt(3)+1;

		if(randomNumber == 1) {
			Tamagotchi tama = new Tamagotchi();
			tama.setName(tamaName);
			tama.generateTamaValue();
			return tama;
		} else if (randomNumber == 2) {
			SadTama sadTama = new SadTama();
			sadTama.setName(tamaName);
			sadTama.generateTamaValue();
			return sadTama;
		} else {
			GreedyTama greedyTama = new GreedyTama();
			greedyTama.setName(tamaName);
			greedyTama.generateTamaValue();
			return greedyTama;
		}
	}
	
	public static void listAllTama(ArrayList<Tamagotchi> tamaList) {
		for (int i = 0; i < tamaList.size(); i++) {
			System.out.println(tamaList.get(i).toString());
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Tamagotchi> tamaList = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
		
		// ==================
		// Creating the CLI
		// ==================
		Menu menu = new Menu();
		menu.addVoice(MENU_EXIT);
		menu.addVoice(MENU_GIVE_COOKIES);
		menu.addVoice(MENU_GIVE_CARESSES);
		menu.setTitle(MENU_TITLE);
		
		// ======
		// Start
		// ======
		System.out.println(GREETINGS);
		
		System.out.println(HOW_MANY_TAMA);
		
		int nOfTama = in.nextInt();
		for(int i = 0; i < nOfTama; i++) {
			System.out.println("Tamagotchi name n" + (i+1) + ":");
			String name = in .next();
			tamaList.add(generateTamagotchi(name));
		}
		
		listAllTama(tamaList);
		
		int choise = 100;
		do {
			menu.printMenu();
			choise = in.nextInt();
			switch (choise) {
			case 1:
				// insert cookies
				System.out.println("How much cookies?");
				int nCookies =in.nextInt();
				// add cookies
				do {
					if(nCookies < 20 || nCookies > 50) {
						System.out.println(VALUE_TO_HIGH_OR_TO_LOW);
					}
				} while (nCookies < 20 || nCookies > 100);
				for (int i = 0; i < tamaList.size(); i++) {
					tamaList.get(i).increaseSatiety(nCookies);
				}
				// check for deaths
				for (int i = 0; i < tamaList.size(); i++) {
					if(tamaList.get(i).death()) {
						tamaList.remove(i);
					}
				}
				// print new values
				listAllTama(tamaList);
				break;
				
			case 2:
				// insert n caresses
				System.out.println("How much caresses?");
				int nCaresses =in.nextInt();
				// add caresses
				do {
					if(nCaresses < 20 || nCaresses > 50) {
						System.out.println(VALUE_TO_HIGH_OR_TO_LOW);
					}
				} while (nCaresses < 20 || nCaresses > 100);
				for (int i = 0; i < tamaList.size(); i++) {
					tamaList.get(i).increaseSatisfaction(nCaresses);
				}
				// check for deaths
				for (int i = 0; i < tamaList.size(); i++) {
					if(tamaList.get(i).death()) {
						tamaList.remove(i);
					}
				}
				// print new values
				listAllTama(tamaList);
				break;

			case 0:
				System.out.println("Program Ended");
				break;
			}
		} while (choise != 0);

	}

}
