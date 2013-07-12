/**
 * 
 * @author yaoruhao
 * Question 17.5
 *
 */
public class Q5 {

	public void gameResult(int []solution, int [] guess) {
		int hitCount = 0;
		int []colorCount = {0, 0, 0, 0};
		for (int i = 0; i < solution.length; i++) {
			if (solution[i] == guess[i]) {
				hitCount++;
			} else {
				colorCount[solution[i]]++;
			}
		}
		int psudoCount = 0;
		for (int i = 0; i < solution.length; i++) {
			if (solution[i] != guess[i] && colorCount[guess[i]] > 0) {
				psudoCount++;
				colorCount[guess[i]]--;
			}
		}
		System.out.println("Hitcount: "+ hitCount + " Psudocount:" + psudoCount);
	}
	public static void main(String[] args) {
		Q5 testQ5 = new Q5();
		int []solution = {0, 2, 1 ,3};
		int []guess = {0, 3, 2, 2};
		testQ5.gameResult(solution, guess);

	}

}
