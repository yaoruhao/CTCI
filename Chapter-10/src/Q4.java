import java.util.BitSet;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 10.4
 *
 */
public class Q4 {

	public void checkDuplicate(LinkedList<Integer> array) {
		BitSet bitSet = new BitSet(32001);
		for (int i = 0; i < array.size(); i++) {
			if (bitSet.get(array.get(i))) {
				System.out.println(array.get(i));
			} else {
				bitSet.set(array.get(i));
			}
		}
	}
	public static void main(String[] args) {
		LinkedList<Integer> inputList = new LinkedList<Integer>();
		Q4 testQ4 = new Q4();
		for (int i = 0; i < 100; i++) {
			inputList.add((int)(Math.random() * 50));
		}
		System.out.println(inputList);
		testQ4.checkDuplicate(inputList);

	}

}
