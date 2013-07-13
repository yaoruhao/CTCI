import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * Question 18.7
 *
 */
public class Q7 {

	HashSet<String> dictionary = new HashSet<String>();
	
	public boolean checkExist(String str, int start) {
		if (start >= str.length()) {
			return true;
		}
		for (int i = start + 1; i <= str.length(); i++) {
			String tempStr = str.substring(start, i);
			if (tempStr.equals(str)) {
				continue;
			}
			if (dictionary.contains(tempStr) && checkExist(str, i)) {
				return true;
			}
		}
		return false;
	}
	
	public void checkAll(String []strs) {
		for (String str : strs) {
			if (checkExist(str, 0)) {
				System.out.println(str);
			}
		}
	}
	public static void main(String[] args) {
		Q7 testQ7 = new Q7();
		String str = "cat banana dog nana walk walker dogwalker";
		String []inputs = str.split(" ");
		for (String string : inputs) {
			testQ7.dictionary.add(string);
		}
		testQ7.checkAll(inputs);

	}

}
