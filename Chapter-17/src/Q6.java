/**
 * 
 * @author yaoruhao
 * Question 17.6
 *
 */
public class Q6 {

	public void findSortSequence(int []inputs) {
		int m = -1;
		int n = -1;
		for (int i = 0; i < inputs.length; i++) {
			boolean flag = false;
			for (int j = i + 1; j < inputs.length; j++) {
				if (inputs[i] > inputs[j]) {
					flag = true;
					m = i;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (m != -1) {
			for (int i = inputs.length - 1; i >= 0; i--) {
				boolean flag = false;
				for (int j = i - 1; j >= 0; j--) {
					if (inputs[j] > inputs[i]) {
						flag = true;
						n = i;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
		}
		if (m != -1 && n != -1) {
			System.out.println(m + " " + n);
		}
	}
	
	public int shrinkLeft(int []array, int minIndex, int start) {
		for (int i = start - 1; i >= 0; i--) {
			if (array[i] <= array[minIndex]) {
				return i + 1;
			}
		}
		return 0;
	}
	public int shrinkRight(int []array, int maxIndex, int start) {
		for (int i = start + 1; i < array.length; i++) {
			if (array[i] >= array[maxIndex]) {
				return i-1;
			}
		}
		return array.length - 1;
	}
	
	public int rightDecreasingends(int []array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public int leftIncreasingEnds(int []array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return i - 1;
			}
		}
		return array.length - 1;
	}
	public void findUnsortedSequence(int [] array) {
		int end_left = leftIncreasingEnds(array);
		int start_right = rightDecreasingends(array);
		int minIndex = end_left + 1;
		if (minIndex >= array.length) {
			return;
		}
		int maxIndex = start_right - 1;
		for (int i = end_left; i <= start_right; i++) {
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		int leftIndex = shrinkLeft(array, minIndex, end_left);
		int rightIndex = shrinkRight(array, maxIndex, start_right);
		System.out.println(leftIndex + " " + rightIndex);
	}
	public static void main(String[] args) {
		Q6 testQ6 = new Q6();
		int []array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		int []inputs = {1};
		testQ6.findSortSequence(array);
		testQ6.findUnsortedSequence(array);
	}

}
