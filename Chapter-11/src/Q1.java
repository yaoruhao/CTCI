import java.util.ArrayList;

/**
 * 
 * @author yaoruhao
 * Question 11.1
 *
 */
public class Q1 {

	public void mergeSort(ArrayList<Integer> a, ArrayList<Integer> b) {
		int aBufferIndex = a.size() - 1;
		int aDataIndex = a.size() - b.size() - 1;
		int bDataIndex = b.size() - 1;
		while (aDataIndex >= 0 && bDataIndex >= 0) {
			if (a.get(aDataIndex) > b.get(bDataIndex)) {
				a.set(aBufferIndex--, a.get(aDataIndex--));
			} else {
				a.set(aBufferIndex--, b.get(bDataIndex--));
			}
		}
		while (bDataIndex >= 0) {
			a.set(aBufferIndex--, b.get(bDataIndex--));
		}
	}
	public static void main(String[] args) {
		Q1 testQ1 = new Q1();
		ArrayList<Integer> a = new ArrayList<Integer>(10);
		ArrayList<Integer> b = new ArrayList<Integer>(5);
		for (int i = 0; i < 5; i++) {
			a.add(i+1);
			b.add(i);
		}
		for (int i = 5; i < 10; i++) {
			a.add(0);
		}
		System.out.println(a);
		System.out.println(b);
		testQ1.mergeSort(a, b);
		System.out.println(a);
	}

}
