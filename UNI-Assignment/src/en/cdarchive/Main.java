package en.cdarchive;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		int choise;
		
		CdArchive cdarchive = new CdArchive();
		
		Scanner in = new Scanner(System.in);
		
		Menu menu = new Menu();
		menu.setTitle("Choose one of the following items");
		menu.addVoice("Exit"); // case 1
		menu.addVoice("Add new CD");
		menu.addVoice("View CD");
		menu.addVoice("Remove CD");
		menu.addVoice("view all archive");
		menu.addVoice("Select a random CD");
		
		do {
			menu.printMenu();
			try {
				do {
					System.out.print("Choise: ");
					choise = in.nextInt();
				} while (choise < 0 || choise >5);
			} catch (NoSuchElementException e) {
				System.out.println("You must enter a number between 0 and 5");
				choise = 0;
			} finally {
				System.out.println("Acquisition finished.");
			}

			
			switch (choise) {
			case 0:
				System.out.println("Program Ended");
				break;
			case 1:
				// CD creation
				CD cd = new CD();
				cd.createNewCD();
				cdarchive.addCD(cd);
				cdarchive.listCD();
				break;
			case 2:
				int cdToVisualize;
				cdarchive.listCD();
				System.out.println("Select the cd to visualize --> ");
				cdToVisualize = in.nextInt();
				cdarchive.getCD(cdToVisualize).showCDInfo();
				break;
			case 3:
				int cdToRemove;
				cdarchive.listCD();
				System.out.print("Select the cd to remove -->");
				cdToRemove = in.nextInt();
				cdarchive.removeCD(cdToRemove);
				break;
			case 4:
				cdarchive.listCD();
				break;
			case 5:
				cdarchive.randomCD();
				break;

			default:
				break;
			}
		} while (choise != 0);
	}

}
