/**
 * 
 * @author yaoruhao
 * Question 11.5
 *
 */
public class Q5 {

	public int searchString(String[] inputs, int begin, int end, String str) {
		int result = -1;
		if (begin > end) {
			return -1;
		}
		int mid = (begin + end) / 2;
		if (inputs[mid].compareTo(str) == 0) {
			return mid;
		}
		if (!inputs[mid].isEmpty()) {
			if (inputs[mid].compareTo(str) < 0) {
				return searchString(inputs, mid + 1, end, str);
			} else {
				return searchString(inputs, begin, mid - 1, str);
			}
		}
		for (int i = 1; i < Math.min(mid - begin, end - mid); i++) {
			if (!inputs[mid - i].isEmpty()) {
				if (inputs[mid - i].compareTo(str) < 0) {
					return searchString(inputs, mid + i, end, str);
				} else {
					return searchString(inputs, begin, mid - i, str);
				}
			}
			if (!inputs[mid + i].isEmpty()) {
				if (inputs[mid + i].compareTo(str) < 0) {
					return searchString(inputs, mid + i, end, str);
				} else {
					return searchString(inputs, begin, mid - i, str);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Q5 testQ5 = new Q5();
		String []inputs = new String[10];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = String.valueOf(i);
		}
		inputs[6] = "";
		inputs[5] = "";
		inputs[2] = "";
		inputs[3] = "";
		System.out.println(testQ5.searchString(inputs, 0, inputs.length - 1, "4"));

	}

}
