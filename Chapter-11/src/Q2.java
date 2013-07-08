import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 11.2
 *
 */
public class Q2 {

	public String sortString(String inputStr) {
		char [] array = inputStr.toCharArray();
		Arrays.sort(array);
		return new String(array);
	}
	
	public void sortStrings(LinkedList<String> inputs) {
		HashMap<String, LinkedList<String>> statMap = new HashMap<String, LinkedList<String>>();
		for (String str : inputs) {
			String s = sortString(str);
			if (statMap.containsKey(s)) {
				statMap.get(s).add(str);
			} else {
				LinkedList<String> tempList = new LinkedList<String>();
				tempList.add(str);
				statMap.put(s, tempList);
			}
		}
		for (String key : statMap.keySet()) {
			System.out.println(statMap.get(key));
		}
	}
	public static void main(String[] args) {
		Q2 testQ2 = new Q2();
		LinkedList<String> inputs = new LinkedList<String>();
		inputs.add("aba");
		inputs.add("aab");
		inputs.add("sadfsadf");
		inputs.add("baa");
		testQ2.sortStrings(inputs);

	}

}
