import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao Question 7.6
 * 
 */
public class Q6 {

	public Line getMostPointLine(ArrayList<Node> nodeList) {
		if (nodeList == null || nodeList.isEmpty()) {
			return null;
		}
		// Only one point, return any line is ok
		if (nodeList.size() == 1) {
			return new Line(nodeList.get(0), new Node(0, 0));
		}
		LinkedList<Line> lineList = new LinkedList<Line>();
		// Generate every line.
		for (int i = 0; i < nodeList.size() - 1; i++) {
			for (int j = i + 1; j < nodeList.size(); j++) {
				lineList.add(new Line(nodeList.get(i), nodeList.get(j)));
			}
		}
		LinkedList<Integer> sameLineNumList = new LinkedList<Integer>();
		//statics for same line num, add remove the duplicate lines.
		for (int i = 0; i < lineList.size() - 1; i++) {
			int count = 1;
			for (int j = i + 1; j < lineList.size(); j++) {
				Line l1 = lineList.get(i);
				Line l2 = lineList.get(j);
				if (l1.toEpsilonPoint(l1.slope()) == l2.toEpsilonPoint(l2
						.slope())
						&& l1.toEpsilonPoint(l1.intersectY()) == l2
								.toEpsilonPoint(l2.intersectY())) {
					count++;
					lineList.remove(j);
					j--;
				}
			}
			sameLineNumList.add(count);
		}
		int maxLineIndex = 0;
		int maxLineCount = 0;
		for (int i = 0; i < sameLineNumList.size(); i++) {
			if (maxLineCount < sameLineNumList.get(i)) {
				maxLineCount = sameLineNumList.get(i);
				maxLineIndex = i;
			}
			
		}
		return lineList.get(maxLineIndex);
	}
	
	public static void main(String[] args) {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		for (int i = 0; i < 10; i++) {
			nodeList.add(new Node(2, i+1));
		}
		for (int i = 0; i < 5; i++) {
			nodeList.add(new Node(Math.random(), Math.random()));
		}
		Q6 testQ6 = new Q6();
		System.out.println(testQ6.getMostPointLine(nodeList).toString());
	}

}
