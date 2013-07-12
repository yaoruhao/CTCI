/**
 * 
 * @author yaoruhao
 * BinaryTreeNode for Chapter-17 solutions.
 *
 */
public class BinaryTreeNode {
	public BinaryTreeNode leftChild;
	public BinaryTreeNode rightChild;
	public BinaryTreeNode parent;
	public boolean leftContains;
	public boolean rightContains;
	public int value;
	//for 4.1 solution
	public int depth;
	
	public BinaryTreeNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
		this.depth = -1;
		leftContains = false;
		rightContains = false;
	}

}
