/**
 * 
 * @author yaoruhao
 * Question 17.11
 *
 */
public class Q11 {

	public double rand5() {
		while (true) {
			double value = Math.random() * 5;
			if (value <= 4) {
				return value;
			}
		}
	}
	
	public double rand7() {
		while (true) {
			double value = 5 * rand5() + rand5();
			if (value <= 21) {
				return value % 7;
			}
		}
	}
	public static void main(String[] args) {
		Q11 testQ11 = new Q11();
		for (int i = 0; i < 10; i++) {
			System.out.println(testQ11.rand7());
		}

	}

}
