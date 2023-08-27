package en.lonelyhearts;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		String GREETING = "Welcome in Lonely Hearts, ere you can know if two people are compatible";
		String ENTER_FIRST_LONELY_HERAT = "Enter the data of the first Lonely Heart: ";
		String ENTER_SECOND_LONELY_HERAT = "Enter the data of the second Lonely Heart: ";
		String ENTER_NAME = "Enter the name: ";
		String ENTER_AGE = "Enter the age: ";
		String ENTER_GENDER = "Enter the gender: ";
		
		String name1, name2;
		int age1, age2;
		String gender1, gender2;
		
		Scanner in = new Scanner(System.in);
		
		
		System.out.println(GREETING);
		
		System.out.println(ENTER_FIRST_LONELY_HERAT);
		System.out.println(ENTER_NAME);
		name1 = in.next();
		System.out.println(ENTER_AGE);
		age1 = in.nextInt();
		System.out.println(ENTER_GENDER);
		gender1 = in.next();
		LonelyHeart LH1 = new LonelyHeart(name1, age1, gender1);
		
		System.out.println(ENTER_SECOND_LONELY_HERAT);
		System.out.println(ENTER_NAME);
		name2 = in.next();
		System.out.println(ENTER_AGE);
		age2 = in.nextInt();
		System.out.println(ENTER_GENDER);
		gender2 = in.next();
		LonelyHeart LH2 = new LonelyHeart(name2, age2, gender2);

	}

}
