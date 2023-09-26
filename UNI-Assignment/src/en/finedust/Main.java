package en.finedust;

import java.util.*;
import en.tamagotchi.Menu;

public class Main {
	
	private static final String PROGRAM_ENDED = "PROGRAM ENDED";
	private static final String MENU_ENTER_NEW_WEEK_DATA = "Enter the data for a new week";
	private static final String MENU_EXIT = "Exit";
	private static final String MENU_TITLE = "Chose one of the following actions";

	public static void main(String[] args) {
		
		int choise;
		
		Scanner in = new Scanner(System.in);
		Menu menu = new Menu();
		menu.setTitle(MENU_TITLE);
		menu.addVoice(MENU_EXIT);
		menu.addVoice(MENU_ENTER_NEW_WEEK_DATA);
		
		do {
			menu.printMenu();
			choise = in.nextInt();
			switch (choise) {
			case 0:
				System.out.println(PROGRAM_ENDED);
				break;
			case 1:
				Week week = new Week();
				week.compileWeek();
				week.averageValueAllarm();
				week.maxValueAllarm();
				break;
			}
		} while (choise != 0);

	}

}
