import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 4.4
 *
 */
public class Q4 {

	public LinkedList<LinkedList<Integer>> buildDepthList(BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		LinkedList<BinaryTreeNode> bfsQueue = new LinkedList<BinaryTreeNode>();
		bfsQueue.add(root);
		//node num counter for each depth
		int depthNodeCount = 1;
		int curCounter = 0;
		LinkedList<LinkedList<Integer>> resultList = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> tempList = new LinkedList<Integer>();
		while (!bfsQueue.isEmpty()) {
			BinaryTreeNode tempNode = bfsQueue.getFirst();
			bfsQueue.removeFirst();
			tempList.add(tempNode.value);
			if (tempNode.leftChild != null) {
				bfsQueue.add(tempNode.leftChild);
				curCounter++;
			}
			if (tempNode.rightChild != null) {
				bfsQueue.add(tempNode.rightChild);
				curCounter++;
			}
			depthNodeCount--;
			if (depthNodeCount == 0) {
				depthNodeCount = curCounter;
				curCounter = 0;
				resultList.add(tempList);
				tempList = new LinkedList<Integer>();
			}
		}		
		return resultList;		
	}
	
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		Q4 testQ4 = new Q4();
		ArrayList<Integer> dataList = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++) {
			dataList.add(i);
		}
		BinaryTreeNode root = testQ3.buildBST(dataList, 0, dataList.size());
		LinkedList<LinkedList<Integer>> resultList = testQ4.buildDepthList(root);
		for (LinkedList<Integer> tempList : resultList) {
			System.out.println(tempList);
		}

	}

}
