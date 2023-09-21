package en.tamagotchi;

import java.util.*;

public class Main {
	
	private static final String VALUE_TO_HIGH_OR_TO_LOW = "You must enter a number between 20 and 100";
	private static final String INPUT_MIS_METCH_EXCEPTION_MESSAGE = "You must enter a number";
	private static final String ACQUISITION_FINISHED = "Acquisition Finished";
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
		
		try {
			do {
				System.out.println(INSERT_HUNGRY);
				hungry =in.nextInt();
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
				love = in.nextInt();
			} while (love < 20 || love > 100);
			tamagotchi.setLove(love);
		} catch(InputMismatchException e) {
			System.out.println(INPUT_MIS_METCH_EXCEPTION_MESSAGE);
		} finally {
			System.out.println(ACQUISITION_FINISHED);
		}
	}

	public static void main(String[] args) {
	
		Tamagotchi tama = new Tamagotchi();
		generateTamagotchi(tama);
		System.out.println(tama.toString());
		
		Menu menu = new Menu();
		menu.setTitle(" ");
		menu.addVoice("1234567890");
		menu.addVoice("0987654321");
		menu.printMenu();
	}

}
