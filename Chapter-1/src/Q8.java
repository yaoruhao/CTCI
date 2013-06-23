/**
 * 
 * @author yaoruhao
 * Question 1.8
 *
 */
public class Q8 {

	//find b from aa
	public boolean findRotateStr(String aStr, String bStr) {
		if (aStr == null || bStr == null || aStr.length() != bStr.length()) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(aStr);
		sb.append(aStr);
		if (sb.indexOf(bStr) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		Q8 testQ8 = new Q8();
		System.out.println(testQ8.findRotateStr(null, ""));
		System.out.println(testQ8.findRotateStr(" ", ""));
		System.out.println(testQ8.findRotateStr("", ""));
		System.out.println(testQ8.findRotateStr("abcd", "abbd"));
		System.out.println(testQ8.findRotateStr("abcd", "cdab"));
	}

}
