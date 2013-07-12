import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * Question 17.4
 *
 */
public class Q14 {

	public HashSet<String> dictionary = new HashSet<>();
	
	public int getUnknownWordNum(int wordstart, int wordend, String str, HashMap<Integer, Integer> cacheMap){
		if (wordend >= str.length()) {
			return wordend - wordstart;
		}
		if (cacheMap.containsKey(wordstart)) {
			return cacheMap.get(wordstart);
		}
		int cutHereCount = getUnknownWordNum(wordend + 1, wordend + 1, str, cacheMap);
		if (!dictionary.contains(str.substring(wordstart, wordend + 1))) {
			cutHereCount += wordend + 1 - wordstart;
		}
		int extendCount = getUnknownWordNum(wordstart, wordend + 1, str, cacheMap);
		int min = Math.min(cutHereCount, extendCount);
		cacheMap.put(wordstart, min);
		return min;
	}
	public static void main(String[] args) {
		Q14 testQ14 = new Q14();
		String inputs = "hello new world this is java anderson";
		String []phrases = inputs.split(" ");
		for (int i = 0; i < phrases.length; i += 2) {
			testQ14.dictionary.add(phrases[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < phrases.length; i++) {
			sb.append(phrases[i]);
		}
		System.out.println(testQ14.dictionary);
		System.out.println(sb.toString());
		System.out.println(testQ14.getUnknownWordNum(0, 0, sb.toString(), new HashMap<Integer, Integer>()));

	}

}
