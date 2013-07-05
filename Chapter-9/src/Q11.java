import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 
 * @author yaoruhao
 * Question 9.11:countDP() is textbook's solution which is correct.
 * Mine solution is wrong, the dp target i choose is just opposite.
 *
 */
public class Q11 {
	
	public static int countDP(String exp, boolean result, int start, int end, HashMap<String, Integer> cache) {
		String key = "" + result + start + end;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		if (start == end) {
			if (exp.charAt(start) == '1' && result == true) {
				return 1;
			} else if (exp.charAt(start) == '0' && result == false) {
				return 1;
			}
			return 0;
		}
		int count = 0;
		if (result) {
			for (int i = start + 1; i <= end; i += 2) {
				char op = exp.charAt(i);
				if (op == '&') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache); 
				} else if (op == '|') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
				} else if (op == '^') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
				}
			}
		} else {
			for (int i = start + 1; i <= end; i += 2) {
				char op = exp.charAt(i);
				if (op == '&') {
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache); 
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
				} else if (op == '|') {
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
				} else if (op == '^') {
					count += countDP(exp, true, start, i - 1, cache) * countDP(exp, true, i + 1, end, cache);
					count += countDP(exp, false, start, i - 1, cache) * countDP(exp, false, i + 1, end, cache);
				}
			}			
		}
		cache.put(key, count);
		return count;
	}

	public HashMap<String, Integer> cacheMap;
	public int findTotalNum(LinkedList<Character> inputList, char result, LinkedList<Character> resultList) {
		//should check input legal, leave it for ease.
		if (inputList.size() == 1) {
			if (inputList.getFirst() == result) {
				return 1;
			} else {
				return 0;
			}
		}
		if (cacheMap.containsKey(inputList.toString())) {
			//System.out.println("Cache map contains:" + inputList.toString() + " number:" + cacheMap.get(inputList.toString()));
			//System.out.println("Result list:" + resultList.toString());
			
			if (cacheMap.get(inputList.toString()) != 0) {
				LinkedList<Character> tempResultList = new LinkedList<Character>();
				tempResultList.addAll(resultList);
				for (Character tempChar : inputList) {
					if (tempChar == '0' || tempChar == '1') {
						continue;
					}
					tempResultList.add(tempChar);
				}
			}
			return cacheMap.get(inputList.toString());
		}
		int count = 0;
		for (int i = 0; i < inputList.size() - 1; i++) {
			if (inputList.get(i) == '0' || inputList.get(i) == '1') {
				continue;
			}
			LinkedList<Character> tempList = new LinkedList<Character>();
			tempList.addAll(inputList.subList(0, i - 1));
			tempList.add(calculateBoolExp(inputList, i));
			if (inputList.size() > i + 2) {
				tempList.addAll(inputList.subList(i + 2, inputList.size()));
			}
			resultList.add(inputList.get(i));
			count += findTotalNum(tempList, result, resultList);
			resultList.removeLast();
		}
		cacheMap.put(inputList.toString(), count);
		return count;
	}
	public char calculateBoolExp(LinkedList<Character> inputList, int opIndex) {
		//should check input legal, leave it for ease.
		int a = inputList.get(opIndex - 1) - '0';
		int b = inputList.get(opIndex + 1) - '0';
		int result = 0;
		switch (inputList.get(opIndex)) {
		case '&':
			result = a & b;
			break;
		case '|':
			result = a | b;
			break;
		case '^':
			result = a ^ b;
			break;
		default:
			break;
		}
		if (result == 0) {
			return '0';
		} else  {
			return '1';
		}
	}
	public Q11 () {
		cacheMap = new HashMap<String, Integer>();
	}
	public static void main(String[] args) {
		Q11 testQ11 = new Q11();
		String inputs = "0^0|1&1^1|0|1";
		LinkedList<Character> inputList = new LinkedList<Character>();
		for (int i = 0; i < inputs.length(); i++) {
			inputList.add(inputs.charAt(i));
		}
		System.out.println(testQ11.findTotalNum(inputList, '1', new LinkedList<Character>()));
		System.out.println(countDP(inputs, true, 0, inputs.length() - 1, new HashMap<String, Integer>()));
	}

}
