/**
 * 
 * @author yaoruhao
 * Question 1.1
 *
 */
public class Q1 {
	
	class Node {
		Node leftChild;
		Node rightChild;
		char value;
		public Node(char value) {
			this.value = value;
			leftChild = null;
			rightChild = null;
		}
	}
	
	public boolean existInTree(char c, Node root) {
		if (root.value == c) {
			return true;
		}
		if (c < root.value) {
			if (root.leftChild == null) {
				root.leftChild = new Node(c);
				return false;
			} else {
				return existInTree(c, root.leftChild);
			}
		} else {
			if (root.rightChild == null) {
				root.rightChild = new Node(c);
				return false;
			} else {
				return existInTree(c, root.rightChild);
			}
			
		}
	}
	
	public boolean isAllCharUnique(String inputStr) {
		if (inputStr == null || inputStr.isEmpty()) {
			return true;
		}
		Node root = new Node(inputStr.charAt(0));
		for (int i = 1; i < inputStr.length(); i++) {
			if (existInTree(inputStr.charAt(i), root)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Q1 testQ1 = new Q1();
		System.out.println(testQ1.isAllCharUnique("aadffreteryeycvbvcb"));
		System.out.println(testQ1.isAllCharUnique(null));
		System.out.println(testQ1.isAllCharUnique(""));
		System.out.println(testQ1.isAllCharUnique("asdferyk"));
	}

}
