/**
 * 
 * @author yaoruhao
 * Question 2.1
 *
 */
public class Q1 {

	public void removeDuplicate(Node inputList) {
		if (inputList == null || inputList.next == null) {
			return;
		}
		Node curPointer = inputList;
		Node iterPointer = inputList;
		while (curPointer.next != null) {
			if (iterPointer.next.value == curPointer.value) {
				iterPointer.next = iterPointer.next.next;
				System.out.println(inputList.toString());
			} else {
				iterPointer = iterPointer.next;
			}			
			if (iterPointer.next == null) {
				curPointer = curPointer.next;
				if (curPointer == null) {
					break;
				}
				iterPointer = curPointer;
			}
		}
	}
	
	public static void main(String[] args) {
		Q1 testQ1 = new Q1();
		Node head = new Node(0);
		System.out.println(head.toString());
		testQ1.removeDuplicate(head);
		System.out.println(head.toString());
		Node n1 = new Node(1);
		head.next = n1;
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(1);
		n2.next = n3;
		Node n4 = new Node(2);
		n3.next = n4;
		Node n5 = new Node(1);
		n4.next = n5;
		Node n6 = new Node(1);
		n5.next = n6;
		
		System.out.println(head.toString());
		testQ1.removeDuplicate(head);
		System.out.println(head.toString());
		
	}

}
