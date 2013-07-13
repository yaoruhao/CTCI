/**
 * 
 * @author yaoruhao
 * Question 18.11
 *
 */
public class Q11 {

	//true for white, false for black
	public boolean matrix[][];
	public int up[][];
	public int down[][];
	public int left[][];
	public int right[][];
	
	public Q11 (boolean [][] inputs) {
		matrix = inputs;
		int length = inputs.length;
		up = new int[length][length];
		down = new int [length][length];
		left = new int [length][length];
		right = new int [length][length];
		for (int i = 0; i < inputs.length; i++) {
			up[i] = new int[length];
			down[i] = new int[length];
			left[i] = new int[length];
			right[i] = new int [length];
			for (int j = 0; j < inputs.length; j++) {
				up[i][j] = -1;
				down[i][j] = -1;
				left[i][j] = -1;
				right[i][j] = -1;
			}
		}
	}
	
	public int getMaxSubSquare() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (!matrix[i][j]) {
					calculateFourLength(i, j);
				}
			}
		}
		int maxLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					continue;
				}
				int currentMaxLength = Math.min(down[i][j], right[i][j]);
				if (currentMaxLength <= 0) {
					continue;
				}
				if (down[i][j + currentMaxLength] >= currentMaxLength && right[i + currentMaxLength][j] >= currentMaxLength) {
					if (currentMaxLength > maxLength) {
						maxLength = currentMaxLength;
						System.out.println(i +"\t" + j);
					}
				}
			}
		}
		return maxLength + 1;
	}
	
	public void calculateFourLength(int x, int y) {
		up[x][y] = 0;
		down[x][y] = 0;
		left[x][y] = 0;
		right[x][y] = 0;
		if (y > 0 && left[x][y-1] != -1) {
			left[x][y] = left[x][y-1] + 1;
		}
		if (x > 0 && up[x-1][y] != -1) {
			up[x][y] = up[x-1][y] + 1;
		}
		if (y > 0 && right[x][y-1] >= 1) {
			right[x][y] = right[x][y-1] - 1;
		} else {
			for (int j = y+1; j < matrix.length; j++) {
				if (matrix[x][j]) {
					break;
				}
				right[x][y]++;
			}
		}
		if (x > 0 && down[x-1][y] >= 1) {
			down[x][y] = down[x-1][y] - 1;
		} else {
			for (int i = x + 1; i < matrix.length; i++) {
				if (matrix[i][y])
					break;
				down[x][y] ++;
			}
		}
	}
	public static void main(String[] args) {
		boolean matrix[][] = new boolean[10][10];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new boolean[10];
			for (int j = 0; j < matrix.length; j++) {
				if (Math.random() > 0.7) {
					matrix[i][j] = true;
					System.out.print("1 ");
				} else {
					matrix[i][j] = false;
					System.out.print("0 ");
				}
				
			}
			System.out.println();
		}
		Q11 testQ11 = new Q11(matrix);
		System.out.println(testQ11.getMaxSubSquare());
	}

}
