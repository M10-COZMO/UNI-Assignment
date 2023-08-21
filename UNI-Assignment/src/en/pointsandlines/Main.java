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
		
		System.out.printf("The distance between the two points is: %.2f \n", p1.isAwayFrom(p2));
		
		System.out.println("The equation of the line passing through this two points is:");
		Line line = new Line(p1, p2);
		System.out.println(line.toString());
		
		System.out.println("Now insert a third point:");
		int x3, y3;
		System.out.println("--- Point 3 ---");
		System.out.print("Coordinate x: ");
		x3 = in.nextInt();
		System.out.print("Coordinate y: ");
		y3 = in.nextInt();
		Point p3 = new Point(x3, y3);
		System.out.println(p3.toString());

		if(line.belongs(p3)) {
			System.out.println("The third point belongs to the line.");
		} else {
			System.out.println("The third point doesn't belong to the line.");
		}
	}
}
