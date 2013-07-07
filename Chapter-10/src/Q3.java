import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 * @author yaoruhao
 * Question 10.3: This solution is referred to the textbook answer.
 *
 */
public class Q3 {

	public int bitsize = 1048576; //2^20 bits
	public int blockNum = 4096; // 2^12
	public byte[] bitfield = new byte[bitsize/8];
	public int[] blocks = new int[blockNum];
	public int getNotContainedInteger() throws FileNotFoundException {
		int result = -1;
		int startBlock = 0;
		Scanner in = new Scanner(new FileReader("input.txt"));
		while (in.hasNext()) {
			int n = in.nextInt();
			blocks[ n/(bitfield.length * 8)]++;
		}
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < bitfield.length * 8) {
				startBlock = i * bitfield.length * 8;
				break;
			}
		}
		in = new Scanner(new FileReader("input.txt"));
		while (in.hasNext()) {
			int n = in.nextInt();
			if (n >= startBlock && n < startBlock + bitfield.length*8) {
				bitfield[(n - startBlock) / 8] |= 1 << ((n - startBlock) % 8);
			}
		}
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				if ((bitfield[i] & (1 << j)) == 0) {
					return i * 8 + startBlock + j;
				}
			}
		}
		
		return result;
	}

}
