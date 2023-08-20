package en.pointsandlines;

public class Point {
	
	private int coordX, coordY;

	public Point(int _coordX, int _coordY) {
		this.coordX = _coordX;
		this.coordY = _coordY;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int _coordX) {
		this.coordX = _coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int _coordY) {
		this.coordY = _coordY;
	}
	
	public String toString() {
		return "(" + coordX + ":" + coordY + ")";
	}

	public float isAwayFrom(Point p) {
		return (float)Math.sqrt(Math.pow((coordX - p.getCoordX()), 2) + Math.pow((coordY -p.getCoordY()), 2));
	}

}
