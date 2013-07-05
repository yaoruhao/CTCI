import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * Question 9.5
 *
 */
public class Q5 {

	public boolean usedFlag[];
	public void printAllPermutations(String str, int leftCount, StringBuilder sb){
		if (leftCount == 0) {
			System.out.println(sb.toString());
			return;
		}
		HashSet<Character> usedCharsThisStep = new HashSet<Character>();
		for (int i = 0; i < usedFlag.length; i++) {
			if (!usedFlag[i] && !usedCharsThisStep.contains(str.charAt(i))) {
				usedCharsThisStep.add(str.charAt(i));
				sb.append(str.charAt(i));
				usedFlag[i] = true;
				printAllPermutations(str, leftCount - 1, sb);
				sb.deleteCharAt(sb.length() - 1);
				usedFlag[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Q5 testQ5 = new Q5();
		String inputStr = "aac";
		testQ5.usedFlag = new boolean[inputStr.length()];
		for (int i = 0; i < testQ5.usedFlag.length; i++) {
			testQ5.usedFlag[i] = false;
		}
		testQ5.printAllPermutations(inputStr, inputStr.length(), new StringBuilder());
	}

}
