package en.pointsandlines;

public class Line {
	
	/*
	 * I will define a straight line with the equation: y = m * x + q.
	 * Where the m is the gradient and the q is the height at witch the line cross the y-axis.
	 */
	private float gradient;
	private float yIntercept;
	private Boolean vertical;
	
	public Line(Point p1, Point p2) {
		
		if (p1.getCoordX() == p2.getCoordX()) {
			vertical = true;
			this.yIntercept = p1.getCoordX();
		} else {
			vertical = false;
			
			// the formula is: gradient = ((y2 - y1) / (x2 - x1))
			gradient = ((p2.getCoordY() - p1.getCoordY()) / (p2.getCoordX() - p1.getCoordX()));
			
			// the formula is: yIntercept = y2 - (gradient * x2)
			yIntercept = p2.getCoordY() - gradient * p2.getCoordX();
		}
	}

	public float getGradient() {
		return gradient;
	}

	public void setGradient(int _gradient) {
		this.gradient = _gradient;
	}

	public float getyIntercept() {
		return yIntercept;
	}

	public void setY_intercept(int _yIntercept) {
		this.yIntercept = _yIntercept;
	}

	public String toString() {
		if (vertical) {
			return String.format("The equation is x = %.2f", yIntercept);
		} else {
			return String.format("The equation is: y = %.2fx + %.2f ", gradient, yIntercept);
		}
	}
	
	public Boolean belongs(Point p) {
		if (vertical) {
			return (yIntercept == p.getCoordX());
		} else {
			return (p.getCoordY() == ((gradient * p.getCoordX()) + yIntercept));
		}
	}

}
