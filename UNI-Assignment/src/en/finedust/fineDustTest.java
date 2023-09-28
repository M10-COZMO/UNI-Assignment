package en.finedust;

public class fineDustTest {

	private static final String AVERAGE_VALUE_TOO_HIGH_ATTENTION_MESSAGE = "- ATTENTION AVERAGE VALUE TOO HIGH -";
	private static final String MAX_VALUE_TOO_HIGH_ALLARM_MESSAGE = "- ATTENTION MAX VALUE TOO HIGH -";
	
	public static void main(String[] args) {
		
		double[] data1 = {23.4, 23, 56, 63, 21.5, 54,7};
		double[] data2 = {23.4, 23, 80, 63, 21.5, 54,7};
		double[] data3 = {60, 59.8, 74.3, 52, 70.4, 69, 67.5};
		Week week1 = new Week(2008, 53, data1);
		Week week2 = new Week(2008, 53, data2);
		Week week3 = new Week(2008, 53, data3);
		
		System.out.println("\n-- First test --");
		System.out.println(week1.maxValueAllarm());
		System.out.println(week1.averageValueAllarm());
		System.out.println("Expected: " + "No Allarm");
		System.out.println("Expected: " + "No Allarm");
		
		System.out.println("\n-- First test --");
		System.out.println(week2.maxValueAllarm());
		System.out.println(week2.averageValueAllarm());
		System.out.println("Expected: " + MAX_VALUE_TOO_HIGH_ALLARM_MESSAGE);
		System.out.println("Expected: " + "No Allarm");
		
		System.out.println("\n-- First test --");
		System.out.println(week3.maxValueAllarm());
		System.out.println(week3.averageValueAllarm());
		System.out.println("Expected: " + "No Allarm");
		System.out.println("Expected: " + AVERAGE_VALUE_TOO_HIGH_ATTENTION_MESSAGE );
	}

}
