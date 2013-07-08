/**
 * 
 * @author yaoruhao
 *
 */
public class Node {
	int value;
	int leftCount;
	Node leftChild;
	Node rightChild;
	public Node(int v){
		value = v;
		leftCount = 0;
		leftChild = null;
		rightChild = null;
	}
}
