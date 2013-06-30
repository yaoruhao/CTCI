/**
 * 
 * @author yaoruhao
 * Question 5.6
 *
 */
public class Q6 {
	
	public int swapOddAndEvenBits(int x) {
		return ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
	}

}
