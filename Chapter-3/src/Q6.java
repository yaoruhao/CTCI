import java.util.Stack;

/**
 * 
 * @author yaoruhao
 * Question 3.6
 *
 */
public class Q6 {
	
	private Stack<Integer> elemStack;
	private Stack<Integer> bufferStack;
	
	public Q6() {
		elemStack = new Stack<Integer>();
		bufferStack = new Stack<Integer>();
	}
	
	public void push(int value) {
		if (elemStack.isEmpty() || elemStack.peek() <= value) {
			elemStack.push(value);
			return;
		}
		while (!elemStack.isEmpty() && elemStack.peek() > value) {
			bufferStack.push(elemStack.pop());
		}
		elemStack.push(value);
		while (!bufferStack.isEmpty()) {
			elemStack.push(bufferStack.pop());
		}
	}
	
	public int pop() {
		if (elemStack.isEmpty()) {
			return -1;
		} else {
			return elemStack.pop();
		}
	}
	
	public boolean isEmpty() {
		return elemStack.isEmpty();
	}

	public static void main(String[] args) {
		Q6 testQ6 = new Q6();
		for (int i = 0; i < 20; i++) {
			testQ6.push((int)(Math.random() * 100));
		}
		while (!testQ6.isEmpty()) {
			System.out.print(testQ6.pop() + " ");
		}

	}

}
