package en.pointsandlines;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int x1, x2, y1, y2;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insert the coordinates of two points, the coordinate must be an integer.");
		System.out.println("--- Point 1 ---");
		System.out.print("Coordinate x: ");
		x1 = in.nextInt();
		System.out.print("Coordinate y: ");
		y1 = in.nextInt();
		Point p1 = new Point(x1, y1);
		System.out.println(p1.toString());
		
		System.out.println("--- Point 2 ---");
		System.out.print("Coordinate x: ");
		x2 = in.nextInt();
		System.out.print("Coordinate y: ");
		y2 = in.nextInt();
		Point p2 = new Point(x2, y2);
		System.out.println(p2.toString());
		
		System.out.printf("The distance between the two points is: %.2f", p1.isAwayFrom(p2));
	}

}
