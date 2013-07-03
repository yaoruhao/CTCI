/**
 * 
 * @author yaoruhao
 * Question 7.4
 *
 */
public class Q4 {

	public int subtract(int a, int b){
		return a + negative(b);
	}
	
	public int multiply(int a, int b){
		if (a == 0 || b == 0) {
			return 0;
		}
		//switch a and b position to reduce loop
		if (abs(a) < abs(b)) {
			int temp = a;
			a = b;
			b = temp;
		}
		int round = b;
		if (b < 0) {
			round = negative(b);
		}
		int sum = 0;
		for (int i = 0; i < round; i++) {
			sum += a;
		}
		if (b < 0) {
			return negative(sum);
		} else {
			return sum;
		}
	}
	
	public int divide(int a, int b) {
		if (b == 0) {
			return Integer.MAX_VALUE;
		}
		boolean negativeFlag = true;
		if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
			negativeFlag = false;
		}
		a = abs(a);
		b = abs(b);
		int sum = b;
		int result = 0;
		while (sum <= a) {
			sum += b;
			result++;
		}
		if (negativeFlag) {
			return negative(result);
		} else {
			return result;
		}
	}
	
	public int abs(int a) {
		if (a < 0) {
			return negative(a);
		} else {
			return a;
		}
	}
	
	public int negative(int a){
		int temp = -1;
		if (a < 0) {
			temp = 1;
		}
		int sum = 0;
		while (a != 0) {
			a += temp;
			sum += temp;
		}
		return sum;
	}
	public static void main(String[] args) {
		Q4 testQ4 = new Q4();
		System.out.println(testQ4.subtract(6, 2));
		System.out.println(testQ4.multiply(-3, 0));
		System.out.println(testQ4.divide(-5, -3));
	}

}
