/**
 * 
 * @author yaoruhao
 * Question 9.9
 *
 */
public class Q9 {

	public int result[];
	public int count;
	public boolean rowAvailable[];
	public boolean leftCrossAvailable[];
	public boolean rightCrossAvailable[];
	public Q9() {
		result = new int[8];
		count = 0;
		rowAvailable = new boolean[8];
		leftCrossAvailable = new boolean[17];
		rightCrossAvailable = new boolean[17];
		for (int i = 0; i < 8; i++) {
			result[i] = -1;
			rowAvailable[i] = true;
		}
		for (int i = 0; i < 17; i++) {
			leftCrossAvailable[i] = true;
			rightCrossAvailable[i] = true;
		}
		printAllPossible(0);
		System.out.println(count);
	}
	public void printAllPossible(int n) {
		if (n == 8) {
			for (int i = 0; i < 8; i++) {
				System.out.print(result[i]);
			}
			System.out.println();
			count++;
		}
		for (int i = 0; i < 8; i++) {
			if (rowAvailable[i] && leftCrossAvailable[n - i + 8] && rightCrossAvailable[n + i]) {
				rowAvailable[i] = false;
				leftCrossAvailable[n - i + 8] = false;
				rightCrossAvailable[n + i] = false;
				result[n] = i;
				printAllPossible(n + 1);
				rowAvailable[i] = true;
				leftCrossAvailable[n - i + 8] = true;
				rightCrossAvailable[n + i] = true;
				
			}
			
		}
	}
	public static void main(String[] args) {
		Q9 testQ9 = new Q9();

	}

}
