/**
 * 
 * @author yaoruhao Question 9.1
 * 
 */
public class Q1 {

	private int resultCache[];

	public int findPossibleWays(int remainStep) {
		if (remainStep < 0) {
			return 0;
		}
		if (remainStep == 1 || remainStep == 0) {
			return 1;
		}
		if (remainStep == 2) {
			return 2;
		}
		if (resultCache[remainStep] != -1) {
			return resultCache[remainStep];
		}
		resultCache[remainStep] = findPossibleWays(remainStep - 3)
				+ findPossibleWays(remainStep - 2)
				+ findPossibleWays(remainStep - 1);
		return resultCache[remainStep];
	}

	public Q1(int n) {
		resultCache = new int[n + 1];
		for (int i = 0; i < resultCache.length; i++) {
			resultCache[i] = -1;
		}
		System.out.println("Possible ways: " + findPossibleWays(n));
	}

	public static void main(String[] args) {
		Q1 testQ1 = new Q1(4);

	}

}
