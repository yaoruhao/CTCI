/**
 * 
 * @author yaoruhao
 * Question 5.3
 *
 */
public class Q3 {

	public int getNextSmallest(int number) {
		int c0 = 0;
		int c1 = 0;
		int temp = number;
		while ((temp & 1) == 0 && temp != 0) {
			temp = temp >> 1;
			c0++;
		}
		while ((temp & 1) == 1) {
			temp = temp >> 1;
			c1++;
		}
		//zero or biggest with current 1 number.
		if (c0 + c1 == 0 || c0 + c1 == 31) {
			return -1;
		}
		//set p spot to 1
		number |= (1 << (c0 + c1));
		//clear spots below p to 0
		number &= ~((1 << (c0 + c1)) - 1);
		//set c1's 1 to the right most.
		number |= ((1 << c1 - 1 ) - 1);
		return number;
	}
	
	public int getPrevBiggest(int number) {
		int c0 = 0;
		int c1 = 0;
		int temp = number;
		while ((temp & 1) == 1 && temp != 0) {
			c1++;
			temp = temp >> 1;
		}
		if (temp == 0) {
			return -1;
		}
		while ((temp & 1) == 0) {
			c0++;
			temp = temp >> 1;
		}
		//set p spot to 0
		number &= ~(1 << (c0 + c1));
		//set spots below p to 1
		number |= ((1 << (c0 + c1)) - 1);
		//set c0's 0 to the right most.
		number &= ~((1 << c0 - 1) - 1);
		return number;
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		System.out.println(testQ3.getNextSmallest(44));
		System.out.println(testQ3.getPrevBiggest(49));

	}

}
