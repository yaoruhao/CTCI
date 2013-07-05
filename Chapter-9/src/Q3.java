/**
 * 
 * @author yaoruhao
 * Question 9.3 : This solution is referred to the textbook answer.
 *
 */
public class Q3 {

	public int findMagicIndex(int []array, int start, int end) {
		if (start < 0 || start > end || end >= array.length) {
			return -1;
		}
		int mid = (start + end)/2;
		if (mid == array[mid]) {
			return mid;
		}
		int leftEnd = Math.min(mid - 1, array[mid]);
		int leftResult = findMagicIndex(array, start, leftEnd);
		if (leftResult != -1) {
			return leftResult;
		}
		int rightBegin = Math.max(mid + 1, array[mid]);
		int rightResult = findMagicIndex(array, rightBegin, end);
			
		return rightResult;
	}

}
