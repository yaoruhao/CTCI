import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao Question 18.10
 * 
 */
public class Q10 {

	public HashSet<String> dictionary = new HashSet<String>();

	public void convertToString(String a, String b) {
		HashMap<String, String> cacheMap = new HashMap<String, String>();
		LinkedList<String> queue = new LinkedList<String>();
		queue.add(a);
		while (!queue.isEmpty()) {
			String temp = queue.pollFirst();
			LinkedList<String> possibleStr = getAllConvertedStrings(temp);
			for (String iterStr : possibleStr) {
				if (iterStr.equals(b)) {
					String outPutString = temp;
					while (cacheMap.containsKey(outPutString)) {
						System.out.println(outPutString);
						outPutString = cacheMap.get(outPutString);
					}
					return;
				}
				if (dictionary.contains(iterStr) && !cacheMap.containsKey(iterStr)) {
					if (!iterStr.equals(cacheMap.get(temp))) {
						cacheMap.put(iterStr, temp);
					}
					
					queue.add(iterStr);
				}
			}
		}
		System.out.println("Can not convert from " + a + " to " + b);
	}

	public LinkedList<String> getAllConvertedStrings(String str) {
		char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };
		LinkedList<String> resultList = new LinkedList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < alpha.length; j++) {
				if (str.charAt(i) != alpha[j]) {
					String tempStr = str.substring(0, i) + alpha[j] + str.substring(i + 1, str.length());
					resultList.add(tempStr);
				}
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		Q10 testQ10 = new Q10();
		String inputs = "damp lamp limp lime like";
		String []phrases = inputs.split(" ");
		for (String str : phrases) {
			testQ10.dictionary.add(str);
		}
		testQ10.convertToString("damp", "liqf");

	}

}
