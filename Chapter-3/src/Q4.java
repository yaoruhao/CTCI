import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @author yaoruhao
 * Question 3.4
 *
 */
public class Q4 {
	public ArrayList<Stack<Integer>> tower;
	
	public Q4(int n) {
		tower = new ArrayList<Stack<Integer>>();
		for (int i = 0; i < 3; i++) {
			tower.add(new Stack<Integer>());
		}
		for (int i = n; i > 0; i--) {
			tower.get(0).push(i);
		}
	}
	
	public void print() {
		for (int i = 0; i < 3; i++) {
			System.out.print("Tower " + i + ":");
			while (!tower.get(i).isEmpty()) {
				System.out.print(tower.get(i).pop() + " ");				
			}
			System.out.println();
		}
	}
	
	public void move(int plateNum, int src, int buffer, int dest) {
		if (plateNum == 0) {
			return;
		}
		move(plateNum - 1, src, dest, buffer);
		moveToTop(src, dest);
		move(plateNum-1, buffer, src, dest);
	}
	public void moveToTop(int src, int dest){
		tower.get(dest).push(tower.get(src).pop());
	}
	
	public static void main(String[] args) {
		Q4 testQ4 = new Q4(10);
		//testQ4.print();
		testQ4.move(10, 0, 1, 2);
		testQ4.print();

	}

}
