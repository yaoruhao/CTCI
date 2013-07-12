/**
 * 
 * @author yaoruhao
 * Question 17.7
 *
 */
public class Q7 {

	//max value is 9999, this is for ease.
	public void pringNumber(int n) {
		String []oneSpot = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
		String []tensSpot = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String []tenSpot = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		StringBuilder sb = new StringBuilder();
		if (n >= 1000) {
			sb.append(oneSpot[n / 1000 - 1] +" thousand ");
			n %= 1000;
		}
		if (n >= 100) {
			sb.append(oneSpot[n / 100 - 1] + " hundred ");
			n %= 100;
		}
		if (n >= 20) {
			sb.append(tensSpot[n/10 - 2] +" ");
		}
		if (n > 10 && n < 20) {
			sb.append(tenSpot[n%10 - 1] + " ");
		} else {
			n %= 10;
			if (n > 0) {
				sb.append(oneSpot[n - 1]);
			}
		}
		
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		Q7 testQ7 = new Q7();
		testQ7.pringNumber(3114);

	}

}
