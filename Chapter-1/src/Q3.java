import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 * Questoin 1.3
 *
 */
public class Q3 {

	public boolean checkPermutation(String aStr, String bStr) {
		if (aStr == null || bStr == null) {  //check null param, false represent illegal.
			return false;
		}
		if (aStr.length() != bStr.length()) { //check length first.
			return false;
		}
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>(); // use hashmap to check, for all characters.
		for (int i = 0; i < aStr.length(); i++) { //statistics for aStr
			char tempChar = aStr.charAt(i);
			if (charMap.containsKey(tempChar)) {
				charMap.put(tempChar, charMap.get(tempChar) + 1);
			} else {
				charMap.put(tempChar, 1);
			}
		}
		for (int i = 0; i < bStr.length(); i++) {
			char tempChar = bStr.charAt(i);
			if (charMap.containsKey(tempChar)) {
				int count = charMap.get(tempChar) - 1;
				if (count == 0) {
					charMap.remove(tempChar);
				} else {
					charMap.put(tempChar, count);
				}
			} else {
				return false;
			}
		}
		if (charMap.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}
	public static void main(String[] args) {
		Q3 testQ3 = new Q3();
		System.out.println(testQ3.checkPermutation("abcdefgass", "sdfdf"));
		System.out.println(testQ3.checkPermutation("abcdefgass", "fgassabcde"));
		System.out.println(testQ3.checkPermutation("abcd", "abce"));
	}

}
