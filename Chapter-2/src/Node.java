/**
 * @author yaoruhao
 * Node for linked list chapter.
 */
public class Node {
	int value;
	Node next;
	public Node() {
		next = null;
		value = -1;
	}
	public Node(int value) {
		this.value = value;
		next = null;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(value);
		Node tempNode = this.next;
		while (tempNode != null) {
			sb.append("->");
			sb.append(tempNode.value);
			tempNode = tempNode.next;			
		}
		return sb.toString();
	}
	
	
}
