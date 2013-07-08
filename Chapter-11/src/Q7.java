import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yaoruhao
 * Question 11.7
 *
 */
public class Q7 {

	HashMap<String, ArrayList<Pair>> cacheMap;
	
	public ArrayList<Pair> searchLongestPath(Pair[] inputs, int round) {
		if (round >= inputs.length) {
			return null;
		}
		if (cacheMap.containsKey(inputs[round].toString())) {
			return cacheMap.get(inputs[round].toString());
		}
		Pair maxSecondPair = null;
		for (int i = 0; i < inputs.length; i++) {
			if (inputs[i].isLessThan(inputs[round])) {
				ArrayList<Pair> tempResult = searchLongestPath(inputs, i);
				if (maxSecondPair == null) {
					maxSecondPair = inputs[i];
				}
				if (cacheMap.get(maxSecondPair.toString()).size() <= tempResult.size()) {
					maxSecondPair = inputs[i];
				}
			}
		}
		ArrayList<Pair> resultList = new ArrayList<Pair>();
		if (maxSecondPair != null) {
			resultList.addAll(cacheMap.get(maxSecondPair.toString()));
		}
		resultList.add(inputs[round]);
		cacheMap.put(inputs[round].toString(), resultList);
		return resultList;
	}
	public static void main(String[] args) {
		Q7 testQ7 = new Q7();
		Pair []inputs = new Pair[10];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new Pair((int)(Math.random() * 20), (int)(Math.random() * 20));
		}
		testQ7.cacheMap = new HashMap<String, ArrayList<Pair>>();
		for (int i = 0; i < inputs.length; i++) {
			testQ7.searchLongestPath(inputs, i);
		}
		for (String str : testQ7.cacheMap.keySet()) {
			System.out.println(testQ7.cacheMap.get(str));
		}

	}

}
