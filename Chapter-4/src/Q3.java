import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 * Question 4.3
 *
 */
public class Q3 {

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
		//for Q7 test
		if (root.leftChild != null) {
			root.leftChild.parent = root;
		}
		if (root.rightChild != null) {
			root.rightChild.parent = root;
		}
		return root;
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			data.add(i);
		}
		BinaryTreeNode root = testQ3.buildBST(data, 0, data.size());
		System.out.println(root);

	}

}
