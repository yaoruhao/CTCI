import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 3.7
 *
 */
public class Q7 {

	class Node {
		int tag;
		int value;
		public Node(int tag, int value) {
			this.tag = tag;
			this.value = value;
		}
	}
	
	private LinkedList<Node> elemList;
	
	public Q7 () {
		elemList = new LinkedList<Node>();
	}
	
	public void enqueue(int value, int tag) {
		elemList.add(new Node(tag, value));
	}
	
	public Node dequeueAny() {
		if (elemList.isEmpty()) {
			return null;
		} else {
			Node resultNode = elemList.getFirst();
			elemList.removeFirst();
			return resultNode;
		}
	}
	
	public Node dequeueType(int tag) {
		if (elemList.isEmpty()) {
			return null;
		} else {
			Node resultNode = null;
			for (int i = 0; i < elemList.size(); i++) {
				if (elemList.get(i).tag == tag) {
					resultNode = elemList.get(i);
					elemList.remove(i);
					break;
				}
			}
			return resultNode;
		}
	}

}
