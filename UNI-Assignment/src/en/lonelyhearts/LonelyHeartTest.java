package en.lonelyhearts;

public class LonelyHeartTest {
	
	public static void main(String[] args) {
		
		LonelyHeart lh1 = new LonelyHeart("Antonio", 34, "M");
		LonelyHeart lh2 = new LonelyHeart("Francesca", 32, "F");
		LonelyHeart lh3 = new LonelyHeart("Marco", 34, "M");
		LonelyHeart lh4 = new LonelyHeart("Anna", 22, "F");
		
		System.out.println(lh1.toString());
		System.out.println(lh2.toString());
		System.out.println(lh3.toString());
		System.out.println(lh4.toString());
		
		System.out.println("\n");
		
		System.out.println("-- First and secondo lonely hearts --");
		System.out.println(lh1.isCompatibleWith(lh2));
		System.out.println("Expected: true");
		
		System.out.println("-- First and third lonely hearts --");
		System.out.println(lh1.isCompatibleWith(lh3));
		System.out.println("Expected: false");
		
		System.out.println("-- First and fourth lonely hearts --");
		System.out.println(lh1.isCompatibleWith(lh4));
		System.out.println("Expected: false");
		
		
	}

}
