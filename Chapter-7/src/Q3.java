/**
 * 
 * @author yaoruhao
 * Question 7.3
 *
 */
public class Q3 {
	
	private double epsilon = 0.000001;
	
	public boolean isIntersected(Line l1, Line l2) {
		//at least one vertical to x-axis
		if (l1.p1.x == l1.p2.x || l2.p2.x == l2.p1.x) {
			if (l1.p1.x == l1.p2.x && l2.p1.x == l2.p2.x) {
				//same line
				if (l1.p1.x == l2.p1.x) {
					return true;
				} else {
					return false;
				}
				//one vertical to x, the other not.
			} else {
				return true;
			}
		}
		if (Math.abs(l1.slope() - l2.slope()) < epsilon) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		Node p1 = new Node(0, 0);
		Node p2 = new Node(0, 1);
		Node p3 = new Node(1, 0);
		Node p4 = new Node(1, 1);
		Line l1 = new Line(p2, p1);
		Line l2 = new Line(p3, p4);
		System.out.println(testQ3.isIntersected(l1, l2));

	}

}
