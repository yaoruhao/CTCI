/**
 * 
 * @author yaoruhao
 * Question 2.3
 *
 */
public class Q3 {

	public void delMidNode(Node list) {
		if (list == null || list.next == null || list.next.next == null) {
			list = null;
			return;
		}
		Node p1 = list;
		Node p2 = list.next.next;
		while (p2 != null) {
			if (p2.next == null) {
				p1.next = p1.next.next;
				return;
			}
			if (p2.next.next == null) {
				p1.next = p1.next.next.next;
			}
			p2 = p2.next.next;
			p1 = p1.next;
		}
	}
	
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
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
		testQ3.delMidNode(head);
		System.out.println(head.toString());
		Node n6 = new Node(6);
		n5.next = n6;
		testQ3.delMidNode(head);
		System.out.println(head.toString());

	}

}
