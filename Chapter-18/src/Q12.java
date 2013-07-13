/**
 * 
 * @author yaoruhao
 * Question 18.12
 *
 */
public class Q12 {

	public int getMaxSumInLine(int [] array) {
		int max = array[0];
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (sum < 0) {
				sum = 0;
			}
			sum += array[i];
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}
	
	public int maxSubSumInMatrix(int [][] matrix) {
		int max = 0;
		int [] rowSum = new int[matrix.length];
		for (int colStart = 0; colStart < matrix.length; colStart++) {
			for (int i = 0; i < rowSum.length; i++) {
				rowSum[i] = 0;
			}
			for (int colEnd = colStart; colEnd < matrix.length; colEnd++) {
				for (int j = 0; j < rowSum.length; j++) {
					rowSum[j] += matrix[colEnd][j];
				}
				int currentMax = getMaxSumInLine(rowSum);
				if (currentMax > max) {
					max = currentMax;
				}
			}
		}
		
		return max;
	}
	public static void main(String[] args) {
		Q12 testQ12 = new Q12();
		int [] array = {-12, 1, 3, -1, 9, -10, 2};
		System.out.println(testQ12.getMaxSumInLine(array));
		int [][]matrix = new int[5][5];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[5];
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = (int) (Math.random() * 20 - 10);
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println(testQ12.maxSubSumInMatrix(matrix));

	}

}
