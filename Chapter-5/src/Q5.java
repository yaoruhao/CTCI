/**
 * 
 * @author yaoruhao
 * Question 5.5
 *
 */
public class Q5 {

	int numOfBitsConverter(int a, int b) {
		int temp = a ^ b;
		int count = 0;
		while (temp != 0) {
			temp = temp & (temp - 1);
			count++;
		}
		return count;
		
	}
	public static void main(String[] args) {
		Q5 testQ5 = new Q5();
		System.out.println(testQ5.numOfBitsConverter(15, 11));

	}

}
