/**
 * 
 * @author yaoruhao
 * Question 2.6
 *
 */
public class Q6 {

	public Node getCircleNode(Node list) {
		if (list == null) {
			return null;
		}
		Node p1 = list;
		Node p2 = list;
		p1 = p1.next;
		p2 = p2.next.next;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		p1 = list;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	public static void main(String[] args) {
		Q6 testQ6 = new Q6();
		Node head = new Node(0);
		Node n1 = new Node(1);
		head.next = n1;
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(4);
		n3.next = n4;
		Node n5 = new Node(5);
		n4.next = n5;
		n5.next = n3;
		System.out.println(testQ6.getCircleNode(head).value);

	}

}
