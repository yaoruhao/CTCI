/**
 * 
 * @author yaoruhao
 * Question 4.1:check binary tree is balanced or not.
 *
 */
public class Q1 {
	public int heightOfNode(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.depth != -1) {
			return root.depth;
		}
		root.depth = Math.max(heightOfNode(root.leftChild), heightOfNode(root.rightChild)) + 1;
		return root.depth;
	}
	
	public boolean isBalanced(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		int leftHeight = heightOfNode(root.leftChild);
		int rightHeight = heightOfNode(root.rightChild);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		} else {
			return isBalanced(root.leftChild) && isBalanced(root.rightChild);
		}
	}
	
	public static void main(String []args) {
		Q1 testQ1 = new Q1();
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(0);
		binaryTreeNode.leftChild = new BinaryTreeNode(1);
		binaryTreeNode.leftChild.rightChild = new BinaryTreeNode(2);
		System.out.println(testQ1.isBalanced(binaryTreeNode));
		
	}

}
