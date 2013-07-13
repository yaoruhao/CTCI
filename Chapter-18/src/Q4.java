/**
 * 
 * @author yaoruhao
 * Question 18.4
 *
 */
public class Q4 {

	public int countNumber(int n, int digit, int number) {
		int powerofTen = (int) Math.pow(10, digit);
		int downBound = n - (n % (powerofTen * 10));
		int upBound = downBound + 10 * powerofTen;
		int numAtDigit = (n / powerofTen) % 10;
		if (numAtDigit < number) {
			return downBound / 10;
		} else if (numAtDigit > number) {
			return upBound / 10;
		} else {
			return downBound / 10 + 1 + n % powerofTen;
		}
	}
	
	public int countNumber(int n, int number) {
		String str = String.valueOf(n);
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += countNumber(n, i, number);
			System.out.println(sum);
		}
		return sum;
	}
	public static void main(String[] args) {
		Q4 testQ4 = new Q4();
		System.out.println(testQ4.countNumber(123, 2));
	}

}
