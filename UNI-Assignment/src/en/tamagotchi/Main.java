package en.tamagotchi;

import java.util.*;

public class Main {
	
	private static final String MENU_TITLE = "Chose one of the following actions";
	private static final String MENU_EXIT = "Exit";
	private static final String MENU_GIVE_COOKIES = "Give Cookies";
	private static final String MENU_GIVE_CARESSES = "Give Caresses";
	private static final String PROGRAM_ENDED_MESSAGE = "Program Ended.";
	private static final String ENTER_YOUR_CHOISE = "Enter your Choise: ";
	private static final String ENTER_DESIRED_VALUE = "Enter desired value: ";
	private static final String VALUE_TO_HIGH_OR_TO_LOW = "You must enter a number between 20 and 100";
	private static final String INPUT_MIS_METCH_EXCEPTION_MESSAGE = "You must enter a number";
	private static final String ACQUISITION_FINISHED = "Acquisition Finished";
	private static final String INSERT_LOVE = "Insert initial level of love: ";
	private static final String INSERT_HUNGRY = "Insert initial level of hungry: ";
	private static final String INSERT_NAME = "Insert name: ";
	private static final String DEATH_MESSAGE = "Your tamagotchi is death";
	
	public static void generateTamagotchi(Tamagotchi tamagotchi) {
		String name;
		int hungry, affection;
		Scanner in = new Scanner(System.in);
		
		System.out.println(INSERT_NAME);
		name = in.next();
		tamagotchi.setName(name);
		
		try {
			do {
				System.out.println(INSERT_HUNGRY);
				hungry =in.nextInt();
				if(hungry < 20 || hungry > 100) {
					System.out.println(VALUE_TO_HIGH_OR_TO_LOW);
				}
			} while (hungry < 20 || hungry > 100);
			tamagotchi.setHungry(hungry);
		} catch(InputMismatchException e) {
			System.out.println(INPUT_MIS_METCH_EXCEPTION_MESSAGE);
		} finally {
			System.out.println(ACQUISITION_FINISHED);
		}
		
		try {
			do {
				System.out.println(INSERT_LOVE);
				affection = in.nextInt();
				if(affection < 20 || affection > 100) {
					System.out.println(VALUE_TO_HIGH_OR_TO_LOW);
				}
			} while (affection < 20 || affection > 100);
			tamagotchi.setAffection(affection);
		} catch(InputMismatchException e) {
			System.out.println(INPUT_MIS_METCH_EXCEPTION_MESSAGE);
		} finally {
			System.out.println(ACQUISITION_FINISHED);
		}
	}

	public static void main(String[] args) {
	
		int choise;
		Scanner in = new Scanner(System.in);
		Tamagotchi tama = new Tamagotchi();
		generateTamagotchi(tama);
		System.out.println(tama.toString());
		
		do {
			Menu menu = new Menu();
			menu.setTitle(MENU_TITLE);
			menu.addVoice(MENU_EXIT);
			menu.addVoice(MENU_GIVE_COOKIES);
			menu.addVoice(MENU_GIVE_CARESSES);
			menu.printMenu();
			
			System.out.println(ENTER_YOUR_CHOISE);
			choise = in.nextInt();
			
			switch (choise) {
			case 0:
				System.out.println(PROGRAM_ENDED_MESSAGE);
				break;
			case 1:
				System.out.println(ENTER_DESIRED_VALUE);
				int cookies = in.nextInt();
				tama.giveCookies(cookies);
				break;
			case 2:
				System.out.println(ENTER_DESIRED_VALUE);
				int caresses = in.nextInt();
				tama.giveCookies(caresses);
				break;
			}
			System.out.println(tama.toString());
			if (tama.death()) {
				choise = 0;
				System.out.println(DEATH_MESSAGE);
				System.out.println(PROGRAM_ENDED_MESSAGE);
			}
		} while (choise != 0);
	}

}
