/**
 * 
 * @author yaoruhao
 * Question 17.3
 *
 */
public class Q3 {

	public int findTrailingZero(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result += factorFiveNum(i);
		}
		return result;
	}
	
	public int factorFiveNum(int number) {
		int result = 0;
		while (number % 5 == 0 && number != 0) {
			result++;
			number /= 5;
		}
		return result;
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		System.out.println(testQ3.findTrailingZero(25));
		System.out.println(testQ3.factorFiveNum(5));

	}

}
