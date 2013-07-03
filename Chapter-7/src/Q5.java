/**
 * 
 * @author yaoruhao
 * Question 7.5
 *
 */
public class Q5 {

	//params are sorted by increasing x coordinator for ease
	//ald is leftdown corner of square a, atr is the topright corner
	public Line cutHalfLine(Node ald, Node atr, Node bld, Node btr){
		Node aCenterNode = new Node((ald.x + atr.x)/2, (ald.y + atr.y)/2);
		Node bCenterNode = new Node((bld.x + btr.x)/2, (bld.y + btr.y)/2);
		Line cutLine = new Line(aCenterNode, bCenterNode);
		//cutLine can be extended to the edge of square.
		return cutLine;
	}

}
