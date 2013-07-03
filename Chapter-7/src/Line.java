/**
 * 
 * @author yaoruhao
 *
 */
class Line {
	Node p1;
	Node p2;
	
	public Line(Node p1, Node p2) {
		//sorted point by x for Q5 ease.
		if (p1.x < p2.x) {
			this.p1 = p1;
			this.p2 = p2;
		} else {
			this.p1 = p2;
			this.p2 = p1;
		}
		
	}
	private double epsilon = 0.0000001;
	public double toEpsilonPoint(double num) {
		if (num == Double.MAX_VALUE) {
			return num;
		}
		int a = (int)(num/epsilon);
		return a * epsilon;
	}
	
	public double intersectY() {
		if (p2.x == p1.x) {
			return Double.MAX_VALUE;
		} else {
			return p1.y - slope()*p1.x;
		}
	}

	public double slope() {
		if (p2.x == p1.x) {
			return Double.MAX_VALUE;
		} else {
			return (p2.y - p1.y) / (p2.x - p1.x);
		}
		
	}

	@Override
	public String toString() {
		return "Line[slope:" + toEpsilonPoint(slope()) + " intersectY:" + toEpsilonPoint(intersectY()) + "]";
	}
	
}