/**
 * 
 * @author yaoruhao
 * Question 5.2
 *
 */
public class Q2 {

	public String getBinaryRepresent(double number) {
		StringBuilder sb = new StringBuilder();
		sb.append("0.");
		double temp = 0.5;
		int round = 0;
		while (number != 0 && round < 32) {
			round++;
			if (number >= temp) {
				sb.append(1);
				number -= temp;
			} else {
				sb.append(0);
			}
			temp /= 2;
		}
		if (number != 0) {
			return "ERROR";
		} else {
			return sb.toString();
		}
	}
	public static void main(String[] args) {
		Q2 testQ2 = new Q2();
		System.out.println(testQ2.getBinaryRepresent(0.625));

	}

}
