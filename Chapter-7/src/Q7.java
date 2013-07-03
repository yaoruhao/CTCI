import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 7.7 : This solution is referred to the textbook answer.
 *
 */
public class Q7 {

	public int getKthMagicNumber(int k) {
		if (k < 0) {
			return 0;
		}
		int val = 0;
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		LinkedList<Integer> list5 = new LinkedList<Integer>();
		LinkedList<Integer> list7 = new LinkedList<Integer>();
		list3.add(1);
		for (int i = 0; i <= k; i++) {
			int v3 = list3.size() > 0 ? list3.getFirst() : Integer.MAX_VALUE;
			int v5 = list5.size() > 0 ? list5.getFirst() : Integer.MAX_VALUE;
			int v7 = list7.size() > 0 ? list7.getFirst() : Integer.MAX_VALUE;
			val = Math.min(v3, Math.min(v5, v7));
			if (val == v3) {
				list3.removeFirst();
				list3.add(3 * val);
				list5.add(5 * val);
			} else if ( val == v5 ) {
				list5.removeFirst();
				list5.add(5 * val);
			} else {
				list7.removeFirst();
			}
			list7.add(7 * val);
		}
		return val;
	}
	public static void main(String[] args) {
		Q7 testQ7 = new Q7();
		System.out.println(testQ7.getKthMagicNumber(4));

	}

}
