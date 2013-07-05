/**
 * 
 * @author yaoruhao
 * Question 9.2
 *
 */
public class Q2 {

	private int resultCache[][];
	public int findPossibleWayCount(int i, int j, int x, int y) {
		if (i == x && j == y) {
			return 1;
		}
		if (i > x || j > y) {
			return 0;
		}
		if (resultCache[i][j] != -1) {
			return resultCache[i][j];
		}
		resultCache[i][j] = findPossibleWayCount(i+1, j, x, y) + findPossibleWayCount(i, j + 1, x, y);
		return resultCache[i][j];
	}
	public Q2 (int n) {
		resultCache = new int [n+1][n+1];
		for (int i = 0; i < resultCache.length; i++) {
			resultCache[i] = new int[n+1];
			for (int j = 0; j < resultCache[i].length; j++) {
				resultCache[i][j] = -1;
			}
		}
	}
	public static void main(String[] args) {
		Q2 testQ2 = new Q2(10);
		System.out.println(testQ2.findPossibleWayCount(0, 0, 2, 1));

	}

}
