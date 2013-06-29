import java.util.Stack;

/**
 * 
 * @author yaoruhao
 * Question 3.5
 *
 */
public class Q5 {

	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;
	public Q5() {
		enqueueStack = new Stack<Integer>();
		dequeueStack = new Stack<Integer>();
	}
	public void enqueue(int value) {
		enqueueStack.push(value);
	}
	
	public int dequeue() {
		if (isEmpty()) {
			return -1;
		}
		if (dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.pop();
	}
	
	public boolean isEmpty() {
		return (enqueueStack.isEmpty() && dequeueStack.isEmpty());
	}
	
	
	public static void main(String[] args) {
		Q5 testQ5 = new Q5();
		for (int i = 0; i < 20; i++) {
			testQ5.enqueue(i);
		}
		while (!testQ5.isEmpty()) {
			System.out.print(testQ5.dequeue() + " ");
		}

	}

}
