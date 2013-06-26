/**
 * 
 * @author yaoruhao
 * Question 2.5
 *
 */
public class Q5 {

	public Node addTwoList(Node a, Node b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		Node ap = a;
		Node bp = b;
		int carry = 0;
		while (ap.next != null && bp.next != null) {
			ap.value += bp.value + carry;
			if (ap.value >= 10) {
				carry = 1;
				ap.value -= 10;
			} else {
				carry = 0;
			}
			ap = ap.next;
			bp = bp.next;
		}
		ap.value += carry + bp.value;
		if (ap.next == null) {
			ap.next = bp.next;
		}
		while (ap.value >= 10) {
			if (ap.next == null) {
				ap.next = new Node(1);
				ap.value -= 10;
				break;
			}
			ap.value -= 10;
			ap.next.value++;
			ap = ap.next;
		}
		return a;
	}
	
	public Node addTwoReverseList(Node aList, Node bList) {
		if (aList == null) {
			return bList;
		}
		if (bList == null) {
			return aList;
		}
		int aLength = 0;
		int bLength = 0;
		Node iterNode = aList;
		//count length
		while (iterNode != null) {
			aLength++;
			iterNode = iterNode.next;
		}
		iterNode = bList;
		while (iterNode != null) {
			bLength++;
			iterNode = iterNode.next;			
		}
		//zero padding
		if (aLength != bLength) {
			Node shortNode = null;
			if (aLength > bLength) {
				shortNode = bList;
			} else {
				shortNode = aList;
			}
			Node tempHead = new Node(0);
			Node tempNode1 = tempHead;
			Node tempNode2 = null;
			for (int i = 0; i < Math.abs(aLength - bLength) - 1; i++) {
				tempNode2 = new Node(0);
				tempNode1.next = tempNode2;
				tempNode1 = tempNode1.next;
			}
			tempNode1.next = shortNode;
			if (aLength > bLength) {
				bList = tempHead;
			} else {
				aList = tempHead;
			}
		}
		Node aIterNode = aList;
		Node bIterNode = bList;
		while (aIterNode != null && bIterNode != null) {
			aIterNode.value += bIterNode.value;
			aIterNode = aIterNode.next;
			bIterNode = bIterNode.next;
		}
		System.out.println(aList.toString() + " " + bList.toString());
		//ten shifting
		//add a new head if headvalue >= 9
		if (aList.value >= 9) {
			Node tempNode = new Node(0);
			if (aList.value > 9) {
				tempNode.value = 1;
				aList.value -= 10;
			}
			tempNode.next = aList;
			aList = tempNode;
		}
		System.out.println(aList.toString() + " " + bList.toString());
		iterNode = aList;
		while (iterNode.next != null) {
			while (iterNode.next != null && iterNode.next.value < 9) {
				iterNode = iterNode.next;
			}
			if (iterNode.next == null) {
				break;
			}
			if (iterNode.next.value > 9) {
				iterNode.value++;
				iterNode.next.value -= 10;
				iterNode = iterNode.next;
				continue;
			}
			Node tempIterNode = iterNode.next;
			while (tempIterNode != null && tempIterNode.value == 9) {
				tempIterNode = tempIterNode.next;
			}
			if (tempIterNode == null) {
				break;
			}
			if (tempIterNode.value < 9) {
				iterNode = tempIterNode;
			} else {
				iterNode.value++;
				iterNode = iterNode.next;
				while (iterNode != tempIterNode) {
					iterNode.value = 0;
					iterNode = iterNode.next;
				}
				iterNode.value -= 10;
			}			
		}
		while (aList != null && aList.value == 0) {
			aList = aList.next;
		}
		
		return aList;
	}
	
	public static void main(String[] args) {
		Q5 testQ5 = new Q5();
		Node head = new Node(6);
		Node n1 = new Node(1);
		head.next = n1;
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(3);
		//n2.next = n3;
		Node n4 = new Node(4);
		n3.next = n4;
		Node n5 = new Node(5);
		n4.next = n5;
		System.out.println(testQ5.addTwoReverseList(head, n3));
	}

}
