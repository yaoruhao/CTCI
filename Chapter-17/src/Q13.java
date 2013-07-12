import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 *
 */
public class Q13 {

	public BinaryTreeNode buildBST(ArrayList<Integer> sortedList, int start, int end) {
		if (start == end) {
			return null;
		}
		if (start + 1 == end) {
			return new BinaryTreeNode(sortedList.get(start));
		}
		BinaryTreeNode root = new BinaryTreeNode(sortedList.get((start + end) / 2));
		root.leftChild = buildBST(sortedList, start, (start + end) / 2);
		root.rightChild = buildBST(sortedList, (start + end) / 2 + 1, end);
		return root;
	}
	
	public BinaryTreeNode convertToList(BinaryTreeNode root, boolean getHead) {
		if (root.leftChild != null) {
			BinaryTreeNode tempNode = convertToList(root.leftChild, false);
			tempNode.rightChild = root;
			root.leftChild = tempNode;
		}
		if (root.rightChild != null) {
			BinaryTreeNode tempNode = convertToList(root.rightChild, true);
			tempNode.leftChild = root;
			root.rightChild = tempNode;
		}
		if (getHead) {
			BinaryTreeNode tempNode = root;
			while (tempNode.leftChild != null) {
				tempNode = tempNode.leftChild;
			}
			return tempNode;
		} else {
			BinaryTreeNode tempNode = root;
			while (tempNode.rightChild != null) {
				tempNode = tempNode.rightChild;
			}
			return tempNode;
		}
	}
	
	public static void main(String[] args) {
		Q13 testQ13 = new Q13();
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			data.add(i);
		}
		BinaryTreeNode root = testQ13.buildBST(data, 0, data.size());
		BinaryTreeNode tail = testQ13.convertToList(root, false);
		System.out.println(tail.value);
		while (tail.leftChild != null) {
			tail = tail.leftChild;
			System.out.println(tail.value);
		}
	}

}
