import java.util.HashSet;

/**
 * 
 * @author yaoruhao
 * Question 9.4
 *
 */
public class Q4 {

	//use int array to represent the input set for ease.
	public HashSet<HashSet<Integer>> getAllSubsets(int []inputs) {
		HashSet<HashSet<Integer>> resultSet = new HashSet<HashSet<Integer>>();
		int []choices = new int[inputs.length];
		for (int i = 0; i < choices.length; i++) {
			choices[i] = 0;
		}
		while (!isAllOne(choices)) {
			resultSet.add(generateSet(inputs, choices));
			increaseChoices(choices);
		}
		resultSet.add(generateSet(inputs, choices));
		return resultSet;
	}
	public void increaseChoices(int []choices) {
		choices[0] += 1;
		for (int i = 0; i < choices.length - 1; i++) {
			if (choices[i] > 1) {
				choices[i] = 0;
				choices[i+1]++;
			}
		}
	}
	public HashSet<Integer> generateSet(int []inputs, int []choices) {
		HashSet<Integer> resultSet = new HashSet<Integer>();
		for (int i = 0; i < choices.length; i++) {
			if (choices[i] == 1) {
				resultSet.add(inputs[i]);
			}
		}
		return resultSet;
	}
	public boolean isAllOne(int []inputs) {
		for (int i = 0; i < inputs.length; i++) {
			if (inputs[i] == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Q4 testQ4 = new Q4();
		int []inputs = new int[3];
		for (int i = 0; i < 3; i++) {
			inputs[i] = i;
		}
		System.out.println(testQ4.getAllSubsets(inputs));

	}

}
