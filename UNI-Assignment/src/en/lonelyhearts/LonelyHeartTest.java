package en.lonelyhearts;

public class LonelyHeartTest {
	
	public static void main(String[] args) {
		
		LonelyHeart lh1 = new LonelyHeart("Antonio", 34, "M", "Aquarius");
		LonelyHeart lh2 = new LonelyHeart("Francesca", 32, "F", "Virgo");
		LonelyHeart lh3 = new LonelyHeart("Marco", 34, "M", "Cancer");
		LonelyHeart lh4 = new LonelyHeart("Anna", 22, "F", "Taurus");
		LonelyHeart lh5 = new LonelyHeart("Claudia", 33, "F", "Acquarius");
		
		System.out.println(lh1.toString());
		System.out.println(lh2.toString());
		System.out.println(lh3.toString());
		System.out.println(lh4.toString());
		System.out.println(lh5.toString());
		
		System.out.println("\n");
		
		System.out.println("-- First and secondo lonely hearts --");
		System.out.println(lh1.isCompatibleWith(lh2));
		System.out.println("Expected: true ~ everithing is compatible");
		
		System.out.println("-- First and third lonely hearts --");
		System.out.println(lh1.isCompatibleWith(lh3));
		System.out.println("Expected: false ~ for same gender");
		
		System.out.println("-- First and fourth lonely hearts --");
		System.out.println(lh1.isCompatibleWith(lh4));
		System.out.println("Expected: false ~ for age difference");
		
		System.out.println("-- First and fifth lonely hearts --");
		System.out.println(lh1.isCompatibleWith(lh5));
		System.out.println("Expected: false ~ for same zodiac sign.");
		
		
	}

}
