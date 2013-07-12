/**
 * 
 * @author yaoruhao
 * Question 17.4
 *
 */
public class Q4 {

	public int findMax(int a, int b) {
		return (a + Math.abs(a - b) + b)/2;
	}
	
	public int flip(int bit) {
		return 1^bit;
	}
	
	public int sign(int num) {
		return (num >> 31) & 0x1;
	}
	public int textbookSolution(int a, int b) {
		int k = sign(a - b);
		int q = flip(k);
		return a * q + b * k;
	}
	public static void main(String[] args) {
		Q4 testQ4 = new Q4();
		System.out.println(testQ4.findMax(-12, -5));
		System.out.println(testQ4.textbookSolution(12, 5));
	}

}
