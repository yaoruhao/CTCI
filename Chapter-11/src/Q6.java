/**
 * 
 * @author yaoruhao
 * Question 11.6
 *
 */
public class Q6 {

	public class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	//tl means top left; br means bottom right.
	public Pair searchMatrix(int[][] matrix, int tlx, int tly, int brx, int bry, int num){
		if (tlx == brx) {
			for (int j = tly; j <= bry; j++) {
				if (matrix[tlx][j] == num) {
					return new Pair(tlx, j);
				}
			}
			return null;
		}
		if (tly == bry) {
			for (int i = tlx; i <= brx ; i++) {
				if (matrix[i][tly] == num) {
					return new Pair(i, tly);
				}
			}
			return null;
		}
		if (tlx > brx || tly > bry) {
			return null;
		}
		int midx = (tlx + brx) / 2;
		int midy = (tly + bry) / 2;
		if (matrix[midx][midy] == num) {
			return new Pair(midx, midy);
		}
		//search top right part
		if (matrix[midx][midy] > num) {
			Pair result = searchMatrix(matrix, tlx, tly, midx - 1, midy - 1, num);
			if (result != null) {
				return result;
			}
		} else { //search botoom right part
			Pair result = searchMatrix(matrix, midx + 1, midy + 1, brx, bry, num);
			if (result != null) {
				return result;
			}
		}
		if (matrix[midx][tly] <= num && matrix[brx][midy] >= num) {
			Pair result = searchMatrix(matrix, midx, tly, brx, midy, num);
			if (result != null) {
				return result;
			}
		}
		if (matrix[tlx][midy] <= num && matrix[midx][bry] >= num) {
			Pair result = searchMatrix(matrix, tlx, midy, midx, bry, num);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Q6 testQ6 = new Q6();
		int [][]matrix = new int[10][10];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[10];
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = count++;
			}
		}
		System.out.println(testQ6.searchMatrix(matrix, 0, 0, 9, 9, 100));

	}

}
