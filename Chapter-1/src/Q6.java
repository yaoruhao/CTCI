/**
 * 
 * @author yaoruhao
 * Question 1.6  learn from the CTCI solution.
 *
 */
public class Q6 {

	public void rotateMatrix(int [][]matrix, int n) {
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				//right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				//top -> right
				matrix[i][last] = top;
			}
		}
	}
	
	public static void main(String[] args) {
		int [][] matrix = {{1,2},{3,4}};
		Q6 testQ6 = new Q6();
		testQ6.rotateMatrix(matrix, 2);
		System.out.println(matrix[0][0] + " " + matrix[0][1]);
		System.out.println(matrix[1][0] + " " + matrix[1][1]);
	}

}
