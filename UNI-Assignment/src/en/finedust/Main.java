package en.finedust;

import java.util.*;
import en.tamagotchi.Menu;

public class Main {
	
	private static final String ENTER_THE_FINE_DUST_DATA = "Enter the fine dust data: ";
	private static final String ENTER_THE_WEEK = "Enter the week (1-53): ";
	private static final String ENTER_THE_YEAR = "Enter the year: ";
	private static final String PROGRAM_ENDED = "PROGRAM ENDED";
	private static final String MENU_ENTER_NEW_WEEK_DATA = "Enter the data for a new week";
	private static final String MENU_EXIT = "Exit";
	private static final String MENU_TITLE = "Chose one of the following actions";
	private static final int DAY_IN_A_WEEK = 7;

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
				
				System.out.println(ENTER_THE_YEAR);
				int year = in.nextInt();
				week.setYear(year);
				
				do {
					System.out.println(ENTER_THE_WEEK);
					int nWeek= in.nextInt();
					week.setnWeek(nWeek);
				} while (week.getnWeek() < 1 || week.getnWeek() > 53);
				
				System.out.println(ENTER_THE_FINE_DUST_DATA);
				double[] fineDustData = new double[DAY_IN_A_WEEK];
				for (int i = 0; i < fineDustData.length; i++) {
					System.out.println("Enter value " + i + ": ");
					fineDustData[i] = in.nextDouble();
				}
				week.setFineDustWeekValue(fineDustData);
				
				System.out.println(week.toString());
				
				System.out.println(week.averageValueAllarm());
				System.out.println(week.maxValueAllarm());
				break;
			}
		} while (choise != 0);
	}
}
