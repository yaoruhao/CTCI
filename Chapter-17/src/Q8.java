import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 17.8
 *
 */
public class Q8 {

	public void printLongestSumSequence(int []array) {
		int tempMax = array[0];
		int maxSum = array[0];
		LinkedList<Integer> tempList = new LinkedList<>();
		LinkedList<Integer> maxList = tempList;
		tempList.add(array[0]);
		for (int i = 1; i < array.length; i++) {
			if (tempMax < 0) {
				tempMax = array[i];
				tempList = new LinkedList<>();
				tempList.add(array[i]);
			} else {
				tempMax += array[i];
				tempList.add(array[i]);
			}
			if (tempMax > maxSum) {
				maxSum = tempMax;
				maxList = (LinkedList<Integer>) tempList.clone();
			}
		}
		System.out.println(maxList.toString());
	}
	public static void main(String[] args) {
		Q8 testQ8 = new Q8();
		int []array = {2, -8, 3, -2, 4, -10};
		testQ8.printLongestSumSequence(array);
	}

}
