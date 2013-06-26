/**
 * 
 * @author yaoruhao
 * Question 2.7
 *
 */
public class Q7 {

	public boolean checkPalindrome(Node nodeList) {
		if (nodeList == null || nodeList.next == null) {
			return true;
		}
		Node p1 = nodeList;
		Node p2 = nodeList;
		Node bufferHead = null;
		Node bufferLast = null;
		while (p2 != null) {
			if (p2.next == null) {
				p1 = p1.next;
				break;
			}
			p2 = p2.next.next;
			bufferHead = new Node(p1.value);
			bufferHead.next = bufferLast;
			bufferLast = bufferHead;
			p1 = p1.next;
		}
		System.out.println(p1.toString() + " " + bufferHead.toString());
		while (p1.next != null && bufferHead.next != null) {
			if (p1.value != bufferHead.value) {
				return false;
			}
			p1 = p1.next;
			bufferHead = bufferHead.next;
		}		
		return true;
	}
	public static void main(String[] args) {
		Q7 testQ7 = new Q7();
		Node head = new Node(6);
		Node n1 = new Node(1);
		head.next = n1;
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(2);
		n2.next = n3;
		Node n4 = new Node(1);
		n3.next = n4;
		Node n5 = new Node(6);
		n4.next = n5;
		System.out.println(testQ7.checkPalindrome(head));
	}

}
