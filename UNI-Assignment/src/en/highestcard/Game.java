package en.highestcard;

import it.unibs.fp.mylib.MyMenu;
import java.util.*;
import en.tamagotchi.*;

public class Game {
	
	private static final String PROGRAM_ENDED = "PROGRAM ENDED";
	private static final String TIE = "TIE...starting a new game";
	private static final String USER_LOST = "USER LOST!";
	private static final String USER_WON = "USER WON!";
	private static final String HOW_MUCH_BET = "How much you want to bet?";
	private static final String FRENCH_DECK = "French Deck";
	private static final String ITALIAN_DECK = "Italian Deck";
	private static final String MENU_EXIT = "Exit";
	private static final String MENU_TITLE = "choose between";
	private static final String ASK_DECK = "Witch type of deck do you want to use?";
	private static final String ASL_USER_CREDIT = "Insert the initial credit";
	private static final String ASK_USER_NAME = "Insert the user name: ";
	private static final String ARROW = "-->";
	private static final String GREETING = "Welcome to Highest Number!";
	private User user;
	private boolean gameOver;
	private int choosenDeck;
	private int userCardValue;
	private int pcCardValue;
	private boolean restartGame;
	private boolean userWin;
	
	public Game(User _user) {
		this.user = _user;
		gameOver = false;
		Menu menu = new Menu();
		menu.setTitle(MENU_TITLE);
		menu.addVoice(MENU_EXIT);
		this.restartGame = false;
	}
	
	
	public void startGame() {
		// greeting + user creation
		System.out.println(GREETING);
		userCreation();
		System.out.println(user.toString());
		
		// choose the deck
		chooseDeck();
		printDeck();
		
		do {
			do {
				// card extraction
				System.out.println("Your card is...");
				extraction(choosenDeck, userCardValue);
				
			// user set card value
				int toBet = 0;
				bet(toBet);
				System.out.println(toBet);
				
			// extraction second card
				System.out.println("The card of the house is..");
				extraction(choosenDeck, pcCardValue);
				
			// max and min
				compareCards(userCardValue, pcCardValue);
				
			// add or remove money
				money(userWin, toBet);
				
			// play again?
				restart();
			} while (restartGame);
		} while(!gameOver);
		System.out.println(PROGRAM_ENDED);
	}
	
	public void game() {
		
	}
	
	public void userCreation() {
		Scanner in = new Scanner(System.in);
		System.out.println(ASK_USER_NAME);
		System.out.print(ARROW);
		String name = in.next();
		user.setName(name);
		System.out.println(ASL_USER_CREDIT);
		System.out.print(ARROW);
		int credit = in.nextInt();
		user.setCredit(credit);
	}
	
	public boolean gameOver(int choose) {
		if(user.getCredit() <= 0) {
			return true;
		} else if (choose == 1) {
			return true;
		} else {
		return false;
		}
	}
	
	public void chooseDeck() {
		Scanner in = new Scanner(System.in);
		Menu menuCarte = new Menu();
		menuCarte.setTitle(MENU_TITLE);
		menuCarte.addVoice(ITALIAN_DECK);
		menuCarte.addVoice(FRENCH_DECK);
		System.out.println(ASK_DECK);
		menuCarte.printMenu();
		choosenDeck = in.nextInt();
	}
	
	public void printDeck() {
		switch (choosenDeck) {
		case 0:
			System.out.println(ITALIAN_DECK + ": ");
			for (ItalianDeck id : ItalianDeck.values()) {
				System.out.println(id);
			}
			break;
		case 1:
			System.out.println(FRENCH_DECK + ": ");
			for (FrenchDeck fd : FrenchDeck.values()) {
				System.out.println(fd);
			}
			break;
		}
	}
	
	public int getChoosenDeck() {
		return choosenDeck;
	}
	
	
	public void extraction(int choose, int value) {
		Random random = new Random();
		if (choose == 0) {
			int val = random.nextInt(10)+1;
			switch (val) {
			case 1:
				System.out.println(ItalianDeck.ASSO);
				value = 1;
				break;
			case 2:
				System.out.println(ItalianDeck.DUE);
				value = 2;
				break;
			case 3:
				System.out.println(ItalianDeck.TRE);
				userCardValue = 3;
				break;
			case 4:
				System.out.println(ItalianDeck.QUATTRO);
				value = 4;
				break;
			case 5:
				System.out.println(ItalianDeck.CINQUE);
				value = 5;
				break;
			case 6:
				System.out.println(ItalianDeck.SEI);
				value = 6;
				break;
			case 7:
				System.out.println(ItalianDeck.SETTE);
				value = 7;
				break;
			case 8:
				System.out.println(ItalianDeck.FANTE);
				value = 8;
				break;
			case 9:
				System.out.println(ItalianDeck.CAVALLO);
				value = 9;
				break;
			case 10:
				System.out.println(ItalianDeck.RE);
				value = 10;
				break;
			default:
				break;
			}
		} else {
			int val = random.nextInt(13)+1;
			switch (val) {
			case 1:
				System.out.println(FrenchDeck.ASSO);
				value = 1;
				break;
			case 2:
				System.out.println(FrenchDeck.DUE);
				value = 2;
				break;
			case 3:
				System.out.println(FrenchDeck.TRE);
				value = 3;
				break;
			case 4:
				System.out.println(FrenchDeck.QUATTRO);
				value = 4;
				break;
			case 5:
				System.out.println(FrenchDeck.CINQUE);
				value = 5;
				break;
			case 6:
				System.out.println(FrenchDeck.SEI);
				value = 6;
				break;
			case 7:
				System.out.println(FrenchDeck.SETTE);
				value = 7;
				break;
			case 8:
				System.out.println(FrenchDeck.OTTO);
				value = 8;
				break;
			case 9:
				System.out.println(FrenchDeck.NOVE);
				value = 9;
				break;
			case 10:
				System.out.println(FrenchDeck.DIECI);
				value = 10;
				break;
			case 11:
				System.out.println(FrenchDeck.JACK);
				value = 11;
				break;
			case 12:
				System.out.println(FrenchDeck.DONNA);
				value = 12;
				break;
			case 13:
				System.out.println(FrenchDeck.RE);
				value = 13;
				break;
			default:
				break;
			}
		}
	}
	
	public void bet(int bet) {
		Scanner in = new Scanner(System.in);
		System.out.println(HOW_MUCH_BET);
		System.out.print(ARROW);
		bet = in.nextInt();
		if (bet >= user.getCredit()) {
			System.out.println("YOu don't have enough credits...\nCurrent credit: " + user.getCredit());
			do {
				System.out.println(HOW_MUCH_BET);
				bet = in.nextInt();
			} while(bet >= user.getCredit());
		}
		System.out.println(bet);
	}
	
	public void restart() {
		Scanner in = new Scanner(System.in);
		Menu menu = new Menu();
		menu.setTitle(MENU_TITLE);
		menu.addVoice("YES");
		menu.addVoice("NO");
		menu.printMenu();
		System.out.println("do you want to restart a new game?");
		int choose = in.nextInt();
		if (choose == 0) {
			restartGame = true;
			gameOver = false;
		} else {
			restartGame = false;
			gameOver = true;
		}
	}
	
	public void money(boolean wol, int bet) {
		if (wol) {
			user.addCredit(bet);
			user.toString();
		} else {
			user.removesCredit(bet);
			user.toString();
		}
	}
	
	public void compareCards(int user, int pc) {
		if (user > pc) {
			System.out.println(USER_WON);
			userWin = true;
		} else if (pc > user) {
			System.out.println(USER_LOST);
			userWin = false;
		} else {
			System.out.println(TIE);
			restartGame = true;
		}
	}
	
}
