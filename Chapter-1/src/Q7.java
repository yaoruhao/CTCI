import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * Question 1.7
 *
 */
public class Q7 {

	public void setZero(int[][] matrix) {
		HashSet<Integer> zeroRowSet = new HashSet<Integer>();
		HashSet<Integer> zeroColumnSet = new HashSet<Integer>();
		//record empty row and column number first
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					zeroColumnSet.add(i);
					zeroRowSet.add(j);
				}
			}
		}
		
		//set column zero
		for (Integer integer : zeroColumnSet) {
			int columnNum = integer.intValue();
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[columnNum][j] = 0;
			}
		}
		//set row zero
		for (Integer integer : zeroRowSet) {
			int rowNum = integer.intValue();
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][rowNum] = 0;
			}
		}
	}
	public static void main(String[] args) {
		int [][] matrix = {{1,2,3}, {0,1,2}};
		Q7 testQ7 = new Q7();
		testQ7.setZero(matrix);
		System.out.println(matrix[0][0] +" "+ matrix[0][1] + " " + matrix[0][2]);
		System.out.println(matrix[1][0] +" "+ matrix[1][1] + " " + matrix[1][2]);
	}

}
