import java.util.Arrays;

/**
 * 
 * @author yaoruhao
 * Question 17.12
 *
 */
public class Q12 {

	public void findPairs(int []array, int sum) {
		Arrays.sort(array);
		int begin = 0;
		int end = array.length - 1;
		while (begin < end) {
			if (array[begin] + array[end] == sum) {
				System.out.println(array[begin] + " " + array[end]);
				begin++;
				end--;
			} else if (array[begin] + array[end] < sum) {
				begin++;
			} else {
				end--;
			}
		}
	}
	public static void main(String[] args) {
		Q12 testQ12 = new Q12();
		int [] array = {2, 3, 4, 5, 6, 7, 1, 8};
		testQ12.findPairs(array, 1);

	}

}
