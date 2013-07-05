/**
 * 
 * @author yaoruhao
 * Question 9.6
 *
 */
public class Q6 {

	public void printAll(int left, int opened, StringBuilder sb){
		if (left == 0) {
			System.out.print(sb.toString());
			for (int i = 0; i < opened; i++) {
				System.out.print(")");
			}
			System.out.println();
			return;
		}
		if (opened > 0) {
			sb.append(")");
			printAll(left, opened - 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("(");
		printAll(left - 1, opened + 1, sb);
		sb.deleteCharAt(sb.length() - 1);
	}
	public static void main(String[] args) {
		Q6 testQ6 = new Q6();
		testQ6.printAll(3, 0, new StringBuilder());

	}

}
