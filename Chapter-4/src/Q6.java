/**
 * 
 * @author yaoruhao
 * Question 4.6
 *
 */
public class Q6 {

	public BinaryTreeNode findNextNode(BinaryTreeNode node) {
		if (node == null) {
			return null;
		}
		//find most left node in right subtree
		if (node.rightChild != null) {
			BinaryTreeNode tempNode = node.rightChild;
			while (tempNode.leftChild != null) {
				tempNode = tempNode.leftChild;
			}
			return tempNode;
		}
		//find correct right father
		if (node.parent != null) {
			BinaryTreeNode tempNode = node;
			while (tempNode.parent != null && tempNode.parent.leftChild != tempNode) {
				tempNode = tempNode.parent;
			}
			if (tempNode.parent.leftChild == tempNode) {
				return tempNode;
			}
		}
		
		return null;
	}

}
