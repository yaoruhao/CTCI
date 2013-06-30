import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Graph node class for Chapter-4 solutions.
 *
 */
public class GraphNode {
	int value;
	LinkedList<GraphNode> adjacentNodes;
	boolean visited;
	public GraphNode(int v) {
		value = v;
		adjacentNodes = new LinkedList<GraphNode>();
		visited = false;
	}

}
