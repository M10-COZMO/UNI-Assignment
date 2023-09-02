package en.lonelyhearts;

import java.util.Scanner;

public class Main {
	
	private static final String INVALID_INPUT_AGE = "Invalid input, you must insert a age between 18 and 120.";
	private static final String INVALID_INPUT_NAME = "Invalid input, you must insert a name.";
	private static final String INVALID_INPUT_GENDER = "Invalid input, insert M o F.";
	private static final String NOT_COMPATIBLE = "They are not compatible";
	private static final String COMPATIBLE = "They are compatible";
	private static final String GREETING = "Welcome in Lonely Hearts, ere you can know if two people are compatible";
	private static final String ENTER_LONELY_HERAT = "Enter lonely heart data: ";
	private static final String ENTER_NAME = "Enter the name: ";
	private static final String ENTER_AGE = "Enter the age: ";
	private static final String ENTER_GENDER = "Enter the gender (M/F): ";
	private static final String MALE = "M";
	private static final String FEMALE = "F";
	
	public static void generateLonelyHeart(LonelyHeart lh) {
		String name;
		int age;
		String gender;
		Scanner in = new Scanner(System.in);
		
		System.out.println(GREETING);
		
		System.out.println(ENTER_LONELY_HERAT);
		System.out.println(ENTER_NAME);
		name = in.next();
		lh.setName(name);
		
		System.out.println(ENTER_AGE);
		age = in.nextInt();
		while(age <= 18 || age >= 120) {
			System.out.println(INVALID_INPUT_AGE);
			age = in.nextInt();
		}
		lh.setAge(age);
		
		System.out.println(ENTER_GENDER);
		gender = in.next();
		while(gender.equals(MALE)|| gender.compareTo(FEMALE) != 0) {
			System.out.println(INVALID_INPUT_GENDER);
			gender = in.next();
		}
		lh.setGender(gender);
		
	}
	public static void main(String[] args) {
	
		LonelyHeart lh1 = new LonelyHeart();
		LonelyHeart lh2 = new LonelyHeart();
		
		generateLonelyHeart(lh1);
		generateLonelyHeart(lh2);
		
		System.out.println(lh1.toString());
		System.out.println(lh2.toString());
		

		if (lh1.isCompatibleWith(lh2) == true) {
			System.out.println(COMPATIBLE);
		} else {
			System.out.println(NOT_COMPATIBLE);
		}
	}

}
