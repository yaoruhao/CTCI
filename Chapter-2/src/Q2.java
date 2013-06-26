/**
 * 
 * @author yaoruhao
 * Question 2.2
 *
 */
public class Q2 {
	public Node getLastNthNode(Node list, int n) {
		if (n < 0 || list == null) {
			return null;
		}
		Node p1 = list;
		Node p2 = list;
		for (int i = 0; i < n; i++) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;			
		}
		return p1;
	}
	
	public static void main(String[] args) {
		Q2 testQ2 = new Q2();
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
		Node n6 = new Node(6);
		n5.next = n6;
		System.out.println(testQ2.getLastNthNode(head, 3).value);

	}

}
