/**
 * 
 * @author yaoruhao
 * Question 4.5
 *
 */
public class Q5 {
	int lastVisited = Integer.MIN_VALUE;
	public boolean isBST(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isBST(root.leftChild)) {
			return false;
		}
		if (root.value <= lastVisited ) {
			return false;
		}
		lastVisited = root.value;
		if (!isBST(root.rightChild)) {
			return false;
		}
		return true;
	}

}
