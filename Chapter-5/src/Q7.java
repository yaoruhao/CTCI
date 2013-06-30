import java.util.ArrayList;
import java.util.BitSet;

/**
 * 
 * @author yaoruhao
 * Question 5.7
 * This solution is referred from the book (quite tricky).
 * Use BitSet instead of the BitInteger from the book solution.
 *
 */
public class Q7 {
	private static final int INTEGER_BIT_SIZE = 32;
	public int findMissing(ArrayList<BitSet> array) {
		return findMissing(array, 0);
	}
	
	public int findMissing(ArrayList<BitSet> input, int column) {
		if (column >= INTEGER_BIT_SIZE) {
			return 0;
		}
		ArrayList<BitSet> oneBits = new ArrayList<BitSet>();
		ArrayList<BitSet> zeroBits = new ArrayList<BitSet>();
		for (BitSet bitSet : input) {
			if (bitSet.get(column)) {
				oneBits.add(bitSet);
			} else {
				zeroBits.add(bitSet);
			}
		}
		if (zeroBits.size() <= oneBits.size()) {
			int v = findMissing(zeroBits, column + 1);
			return (v << 1) | 0;
		} else {
			int v = findMissing(oneBits, column + 1);
			return (v << 1) | 1;
		}
	}

}
