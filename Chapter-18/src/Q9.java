import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 18.9
 *
 */
public class Q9 {

	public class Node {
		int value;
		Node leftChild;
		Node rightChild;
		Node parent;
		public Node (int v) {
			value = v;
			leftChild = null;
			rightChild = null;
			parent = null;
		}
	}
	public int leftCount = 0;
	public int rightCount = 0;
	public Node rootNode;
	
	public int getMedian() {
		if (rootNode != null) {
			return rootNode.value;
		} else {
			return Integer.MAX_VALUE;
		}
	
	}
	
	public void insert(int value){
		if (rootNode == null) {
			rootNode = new Node(value);
			return;
		}
		insertValue(rootNode, value);
		if (value <= rootNode.value) {
			leftCount++;
		} else {
			rightCount++;
		}
		if (leftCount > rightCount + 1) {
			Node tempNode = popMax(rootNode.leftChild);
			System.out.println("pop max:" + tempNode.value);
			tempNode.leftChild = rootNode.leftChild;
			tempNode.rightChild = rootNode;
			rootNode.leftChild = null;
			rootNode.parent = tempNode;
			rootNode = tempNode;
			leftCount--;
			rightCount++;
		} else if (rightCount > leftCount + 1) {
			Node tempNode = popMin(rootNode.rightChild);
			System.out.println("pop min:" + tempNode.value);
			tempNode.rightChild = rootNode.rightChild;
			tempNode.leftChild = rootNode;
			rootNode.rightChild = null;
			rootNode.parent = tempNode;
			rootNode = tempNode;
			rightCount--;
			leftCount++;
		}
	}
	
	public Node popMax(Node root) {
		while (root.rightChild != null) {
			root = root.rightChild;
		}
		
		if (root == root.parent.leftChild) {
			root.parent.leftChild = root.leftChild;
		} else {
			root.parent.rightChild = root.leftChild;
		}
		root.leftChild = null;
		root.parent = null;
		return root;
	}
	
	public Node popMin(Node root) {
		while (root.leftChild != null) {
			root = root.leftChild;
		}
		if (root == root.parent.leftChild) {
			root.parent.leftChild = root.rightChild;
		} else {
			root.parent.rightChild = root.rightChild;
		}
		root.rightChild = null;
		root.parent = null;
		return root;
	}
	
	public void insertValue(Node root, int value) {
		if (value <= root.value) {
			if (root.leftChild == null) {
				Node tempNode = new Node(value);
				root.leftChild = tempNode;
				tempNode.parent = root;
			} else {
				insertValue(root.leftChild, value);
			}
		} else {
			if (root.rightChild == null) {
				Node tempNode = new Node(value);
				root.rightChild = tempNode;
				tempNode.parent = root;
			} else {
				insertValue(root.rightChild, value);
			}
		}
	}
	
	public static void main(String[] args) {
		Q9 testQ9 = new Q9();
		LinkedList<Integer> inputs = new LinkedList<Integer>();
		for (int i = 0; i < 11; i++) {
			int random = (int) (Math.random() * 20);
			System.out.println(random);
			inputs.add(random);
			testQ9.insert(random);
			
		}
		Collections.sort(inputs);
		System.out.println(inputs);
		System.out.println("median:" + testQ9.getMedian());

	}

}
