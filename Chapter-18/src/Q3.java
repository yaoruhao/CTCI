/**
 * 
 * @author yaoruhao
 * Question 18.3
 *
 */
public class Q3 {

	public int[] getRandom(int []array, int m){
		int []result = new int[m];
		for (int i = 0; i < result.length; i++) {
			result[i] = array[i];
		}
		for (int i = m; i < array.length; i++) {
			int random = (int) (Math.random() * i);
			if (random < m) {
				result[random] = array[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		int [] inputs = new int[20];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = i;
		}
		int [] results = testQ3.getRandom(inputs, 5);
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}

	}

}
