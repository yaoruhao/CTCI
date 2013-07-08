/**
 * 
 * @author yaoruhao
 * Question 11.8
 *
 */
public class Q8 {

	public Node rootNode;
	public boolean init = true;
	public void track(int v, Node root){
		if (init) {
			rootNode = new Node(v);
			init = false;
			return;
		}
		if (root == null) {
			root = new Node(v);
			return;
		}
		if (v <= root.value) {
			root.leftCount++;
			if (root.leftChild == null) {
				Node tempNode = new Node(v);
				root.leftChild = tempNode;
				return;
			}
			track(v, root.leftChild);
		} else {
			if (root.rightChild == null) {
				Node tempNode = new Node(v);
				root.rightChild = tempNode;
				return;
			}
			track(v, root.rightChild);
		}
	}
	public int rank(int v, Node root){
		if (root == null) {
			return -1;
		}
		if (root.value == v) {
			return root.leftCount + 1;
		}
		if (root.value > v) {
			return rank(v, root.leftChild);
		} else {
			int rightRank = rank(v, root.rightChild);
			if (rightRank == -1) {
				return rightRank;
			}
			return rightRank+ 1 + root.leftCount;
		}
	}
	public void inOrderTraverse(Node node) {
		if (node.leftChild != null) {
			inOrderTraverse(node.leftChild);
		}
		System.out.println(node.value + "|" + node.leftCount);
		if (node.rightChild != null) {
			inOrderTraverse(node.rightChild);
		}
	}
	public static void main(String[] args) {
		Q8 testQ8 = new Q8();
		for (int i = 0; i < 10; i++) {
			int randomNum = (int)(Math.random() * 20);
			testQ8.track(randomNum, testQ8.rootNode);
			System.out.print(randomNum + " ");
		}
		System.out.println();
		testQ8.inOrderTraverse(testQ8.rootNode);
		System.out.println(testQ8.rank(5, testQ8.rootNode));

	}

}
