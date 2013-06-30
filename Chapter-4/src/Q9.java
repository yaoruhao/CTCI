import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 4.9
 *
 */
public class Q9 {
	
	//for prune and ease, node's value is positive
	//negative value can be done also, but without prune.
	public void printSumValues(BinaryTreeNode root, int value, LinkedList<Integer> pathValueList) {
		if (root == null) {
			return;
		}
		if (root.value > value && !pathValueList.isEmpty()) {
			return;
		}
		if (root.value == value) {
			pathValueList.add(root.value);
			System.out.println(pathValueList);
			pathValueList.removeLast();
		}
		//path with root
		if (root.value < value) {
			pathValueList.add(root.value);
			printSumValues(root.leftChild, value - root.value, pathValueList);
			printSumValues(root.rightChild, value - root.value, pathValueList);
			pathValueList.removeLast();
		}
		//path without root
		int originValue = value;
		//calculate the original value
		for (Integer integer : pathValueList) {
			originValue += integer;
		}
		printSumValues(root.leftChild, originValue, new LinkedList<Integer>());
		printSumValues(root.rightChild, originValue, new LinkedList<Integer>());
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		Q9 testQ9 = new Q9();
		ArrayList<Integer> dataList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			dataList.add(i);
		}
		BinaryTreeNode root = testQ3.buildBST(dataList, 0, dataList.size());
		testQ9.printSumValues(root, 3, new LinkedList<Integer>());

	}

}
