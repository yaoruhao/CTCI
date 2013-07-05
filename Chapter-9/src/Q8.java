/**
 * 
 * @author yaoruhao
 * Question 9.8
 *
 */
public class Q8 {

	//for dp cache [value][coinStartIndex]
	public int[][] resultCache;
	public int[] coinValue = {25, 10, 5, 1};
	public int[] coinUsedNum;
	public int calResult(int n, int coinIndex) {
		if (coinIndex == 3) {
			if (n > 0) {
				coinUsedNum[3] = n;
				//print coinvalue used num result
				for (int i = 0; i < coinUsedNum.length; i++) {
					System.out.print(coinUsedNum[i] + " ");
				}
				System.out.println();
				return 1;
			}
		}
		if (n == 0) {
			for (int i = coinIndex; i < coinUsedNum.length; i++) {
				coinUsedNum[i] = 0;
			}
			for (int i = 0; i < coinUsedNum.length; i++) {
				//print coinvalue used num result
				System.out.print(coinUsedNum[i] + " ");
			}
			System.out.println();
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (resultCache[n][coinIndex] != -1) {
			return resultCache[n][coinIndex];
		}
		int tempValue = n;
		resultCache[n][coinIndex] = 0;
		coinUsedNum[coinIndex] = 0;
		//use each type of coin from 0 to max to search all result.
		while (tempValue >= 0) {
			resultCache[n][coinIndex] += calResult(tempValue, coinIndex + 1);
			tempValue -= coinValue[coinIndex];
			coinUsedNum[coinIndex]++;
		}
		return resultCache[n][coinIndex];
	}
	public Q8(int n) {
		resultCache = new int[n+1][4];
		coinUsedNum = new int[4];
		for (int i = 0; i < coinUsedNum.length; i++) {
			coinUsedNum[i] = 0;
		}
		for (int i = 0; i < n + 1; i++) {
			resultCache[i] = new int[4];
			for (int j = 0; j < 3; j++) {
				resultCache[i][j] = -1;
			}
			resultCache[i][3] = 1;
		}
		System.out.println(calResult(n, 0));
	}
	public static void main(String[] args) {
		Q8 testQ8 = new Q8(100);
	}

}
