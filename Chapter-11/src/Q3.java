/**
 * 
 * @author yaoruhao
 * Question 11.3
 *
 */
public class Q3 {

	public int search(int []array, int start, int end, int number) {
		int result = -1;
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] == number) {
			return mid;
		}
		if (array[start] < array[mid]) {
			if (number >= array[start] && number <= array[mid]) {
				return search(array, start, mid - 1, number);
			} else {
				return search(array, mid + 1, end, number);
			}
		}
		if (array[mid] < array[start]) {
			if (number >= array[mid] && number <= array[end]) {
				return search(array, mid + 1, end, number);
			} else {
				return search(array, start, mid - 1, number);
			}
		}
		if (array[mid] == array[start]) {
			if (array[mid] != array[end]) {
				return search(array, mid + 1, end, number);
			}
			result = search(array, start, mid - 1, number);
			if (result != -1) {
				return result;
			}
			result = search(array, mid + 1, end, number);
		}
		return result;
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		int []inputs = new int[20];
		for (int i = 0; i < 10; i++) {
			inputs[i] = 10;
		}
		for (int i = 10; i < inputs.length; i++) {
			inputs[i] = 10;
		}
		inputs[3] = 15;
		for (int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i]);
		}
		System.out.println(testQ3.search(inputs, 0, inputs.length - 1, 15));
	}

}
