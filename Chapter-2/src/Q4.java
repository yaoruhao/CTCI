/**
 * 
 * @author yaoruhao
 * Question 2.4
 *
 */
public class Q4 {
	public void partition(Node list, int x) {
		if (list == null || list.next == null) {
			return;
		}
		Node p1 = list;
		Node p2 = list;
		while (true) {
			while (p1.value < x && p1.next != null) {
				p1 = p1.next;
			}
			if (p1.next == null) {
				return;
			}
			p2 = p1.next;
			while (p2 != null && p2.value >= x) {
				p2 = p2.next;
			}
			if (p2 == null) {
				return;
			}
			int temp = p1.value;
			p1.value = p2.value;
			p2.value = temp;
			p1 = p1.next;
		}
	}
	
	public static void main(String[] args) {
		Q4 testQ4 = new Q4();
		Node head = new Node(7);
		Node n1 = new Node(1);
		head.next = n1;
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(4);
		n2.next = n3;
		Node n4 = new Node(3);
		n3.next = n4;
		Node n5 = new Node(6);
		n4.next = n5;
		testQ4.partition(head, 4);
		System.out.println(head.toString());

	}

}
