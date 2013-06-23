/**
 * 
 * @author yaoruhao
 * Question 1.5
 *
 */
public class Q5 {
	public String compress(String inputStr) {
		if (inputStr == null || inputStr.isEmpty()) {
			return inputStr;
		}
		StringBuilder sb = new StringBuilder();
		char lastChar = inputStr.charAt(0);
		int lastCount = 1;
		sb.append(lastChar);
		for (int i = 1; i < inputStr.length(); i++) {
			char tempChar = inputStr.charAt(i);
			if (lastChar == tempChar) {
				lastCount++;
				continue;
			}
			sb.append(lastCount);
			lastChar = tempChar;
			sb.append(lastChar);
			lastCount = 1;
		}
		sb.append(lastCount);
		if (sb.length() < inputStr.length()) {
			return sb.toString();
		} else {
			return inputStr;
		}
		
	}

	public static void main(String[] args) {
		Q5 testQ5 = new Q5();
		System.out.println(testQ5.compress("abcdefggg"));
		System.out.println(testQ5.compress(""));
		System.out.println(testQ5.compress("a"));
		System.out.println(testQ5.compress("aaaaaaaaabbbbccccccccaccc"));
	}

}
