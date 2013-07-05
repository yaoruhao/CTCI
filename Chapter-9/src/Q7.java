/**
 * 
 * @author yaoruhao
 * Question 9.7
 *
 */
public class Q7 {

	public int matrix[][];
	public void paintFill(int x, int y, int oldColor, int newColor) {
		if (x < 0 || x >= matrix[0].length || y < 0 || y >= matrix.length) {
			return;
		}
		if (matrix[x][y] == newColor) {
			return;
		}
		matrix[x][y] = newColor;
		paintFill(x + 1, y, oldColor, newColor);
		paintFill(x - 1, y, oldColor, newColor);
		paintFill(x, y + 1, oldColor, newColor);
		paintFill(x, y - 1, oldColor, newColor);
	}
	public static void main(String[] args) {
		Q7 testQ7 = new Q7();
		testQ7.matrix = new int [5][5];
		for (int i = 0; i < 5; i++) {
			testQ7.matrix[i] = new int [5];
			for (int j = 0; j < 5; j++) {
				testQ7.matrix[i][j] = (int) (Math.random() * 9 % 2);
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(testQ7.matrix[i][j]);
			}
			System.out.println();
		}
		testQ7.paintFill(0, 0, 0, 1);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(testQ7.matrix[i][j]);
			}
			System.out.println();
		}

	}

}
