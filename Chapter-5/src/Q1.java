/**
 * 
 * @author yaoruhao
 * Question 5.1
 *
 */
public class Q1 {

	public int updateBits(int n, int m, int i, int j) {
		int leftOnes = ~((1 << (j + 1)) - 1);
		int rightOnes = (1 << i) - 1;
		int mask = leftOnes | rightOnes;
		n &= mask;
		n |= m << i;
		return n;
	}
	public static void main(String[] args) {
		Q1 testQ1 = new Q1();
		System.out.println(testQ1.updateBits(8, 3, 1, 2));

	}

}
