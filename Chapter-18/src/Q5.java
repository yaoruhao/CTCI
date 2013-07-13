/**
 * 
 * @author yaoruhao
 * Question 18.5
 *
 */
public class Q5 {

	public int minDistance(String[] words, String wordA, String wordB){
		int lastAPos = -1;
		int lastBPos = -1;
		int min = Integer.MAX_VALUE;
		int distance = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(wordA)) {
				lastAPos = i;
				distance = lastAPos - lastBPos;
				if (distance < min && lastBPos != -1) {
					min = distance;
				}
			}
			if (words[i].equals(wordB)) {
				lastBPos = i;
				distance = lastBPos - lastAPos;
				if (distance < min && lastAPos != -1) {
					min = distance;
				}
			}
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
