/**
 * 
 * @author yaoruhao
 * Question 1.4
 *
 */
public class Q4 {

	public String replaceSpace(String inputStr) {
		if (inputStr == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inputStr.length(); i++) {
			char tempChar = inputStr.charAt(i);
			if (Character.isSpaceChar(tempChar)) {
				sb.append("%20");
			} else {
				sb.append(tempChar);
			}
		}
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		Q4 testQ4 = new Q4();
		System.out.println(testQ4.replaceSpace(""));
		System.out.println(testQ4.replaceSpace("sadf  sdfsafd   sadf"));
		System.out.println(testQ4.replaceSpace("dsagasgwqre"));
		System.out.println(testQ4.replaceSpace("a"));
		System.out.println(testQ4.replaceSpace(" "));
		System.out.println(testQ4.replaceSpace(null));
	}

}
