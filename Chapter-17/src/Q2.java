/**
 * 
 * @author yaoruhao
 * Question 17.2
 *
 */
public class Q2 {

	//0 for empty
	public int winTicTacToe(int matrix[][]) {
		for (int i = 0; i < 3; i++) {
			//column
			if (matrix[i][0] != 0 && matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2]) {
				return matrix[i][0];
			}
			//row
			if (matrix[0][i] != 0 && matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i]) {
				return matrix[0][i];
			}
		}
		if (matrix[0][0] != 0 && matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
			return matrix[0][0];
		}
		if (matrix[1][1] != 0 && matrix[1][1] == matrix[2][0] && matrix[1][1] == matrix[0][2]) {
			return matrix[1][1];
		}
		
		return 0;
	}

}
