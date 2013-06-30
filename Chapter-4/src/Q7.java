import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 4.7
 *
 */
public class Q7 {
	
	public boolean contains(BinaryTreeNode root, int a, int b) {
		if (root == null) {
			return false;
		}
		if (root.value == a || root.value == b) {
			return true;
		}
		return contains(root.leftChild, a, b) || contains(root.rightChild, a, b);
	}
	//use value a b represent node for convenience
	public boolean findFirstCommonAncestor(BinaryTreeNode root, int a, int b, LinkedList<BinaryTreeNode> resultList) {
		if (!resultList.isEmpty()) {
			return true;
		}
		if (root == null) {
			return false;
		}
		root.leftContains = contains(root.leftChild, a, b);
		root.rightContains = contains(root.rightChild, a, b);
		if (root.leftContains && root.rightContains) {
			resultList.add(root);
			return true;
		}
		if (!resultList.isEmpty()) {
			return true;
		}
		if ((root.value == a || root.value == b) && (root.leftContains || root.rightContains)) {
			resultList.add(root);
			return true;
		}
		if (!root.leftContains && !root.rightContains) {
			return false;
		}
		if (root.leftContains) {
			findFirstCommonAncestor(root.leftChild, a, b, resultList);
		}
		if (root.rightContains) {
			findFirstCommonAncestor(root.rightChild, a, b, resultList);
		}
		if (root.value == a || root.value == b) {
			System.out.println("here");
		}
		return false;
	}
	
	public static void main(String[] args) {
		Q7 testQ7 = new Q7();
		Q3 testQ3 = new Q3();
		ArrayList<Integer> dataList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			dataList.add(i);
		}
		BinaryTreeNode root = testQ3.buildBST(dataList, 0, dataList.size());
		LinkedList<BinaryTreeNode> resultList = new LinkedList<BinaryTreeNode>();
		testQ7.findFirstCommonAncestor(root, 2, 6, resultList);
		System.out.println(resultList.getFirst().value);
	}

}
