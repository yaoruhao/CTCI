/**
 * 
 * @author yaoruhao
 * Question 18.1
 *
 */
public class Q1 {

	public int add(int a, int b){
		int result = 0;
		boolean carry = false;
		for (int i = 0; i < 32; i++) {
			if (((a & b) & (1 << i)) != 0) {
				if (carry) {
					result |= (1 << i);
				}
				carry = true;
			} else if (((a | b) & (1 << i)) != 0) {
				if (!carry) {
					result |= (1 << i);
				}
			} else {
				if (carry) {
					carry = false;
					result |= (1 << i);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Q1 testQ1 = new Q1();
		System.out.println(testQ1.add(10, 20000));

	}

}
