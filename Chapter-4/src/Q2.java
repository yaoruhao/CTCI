import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 4.2
 *
 */
public class Q2 {
	public boolean hasRoute(GraphNode src, GraphNode dest) {
		if (src == dest) {
			return true;
		}
		LinkedList<GraphNode> queueList = new LinkedList<GraphNode>();
		queueList.add(src);
		while (!queueList.isEmpty()) {
			GraphNode node = queueList.getFirst();
			queueList.removeFirst();
			node.visited = true;
			for (GraphNode graphNode : node.adjacentNodes) {
				if (graphNode == dest) {
					return true;
				}
				if (!graphNode.visited) {
					queueList.add(graphNode);
				}
			}
		}
		return false;
	}

}
