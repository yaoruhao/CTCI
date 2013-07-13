/**
 * 
 * @author yaoruhao
 * Question 18.6
 *
 */
public class Q6 {

	public int partition(int[]array, int start, int end, int pivot) {
		while (true) {
			while (array[start] <= pivot) {
				start++;
			}
			while (array[end] > pivot) {
				end--;
			}
			if (start > end) {
				return start - 1;
			}
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
		}
	}
	
	public int rank(int []array, int start, int end, int rank) {
		int pivot = array[(start + end) /2];
		int leftEnd = partition(array, start, end, pivot);
		int leftSize = leftEnd - start + 1;
		if (leftSize == rank + 1) {
			return Math.max(array.length, Math.max(start, leftEnd));
		} else if (rank < leftSize) {
			return rank(array, start, leftEnd, rank);
		} else {
			return rank(array, leftEnd + 1, end, rank - leftSize);
		}
	}

}
