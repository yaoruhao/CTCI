/**
 * 
 * @author yaoruhao
 * Question 18.2
 *
 */
public class Q2 {

	public void shuffle(int []array) {
		for (int i = 1; i < array.length; i++) {
			int random = (int) (Math.random() * i);
			int temp = array[i];
			array[i] = array[random];
			array[random] = temp;
		}
	}
	public static void main(String[] args) {
		Q2 testQ2 = new Q2();
		int [] array = new int[52];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		testQ2.shuffle(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
