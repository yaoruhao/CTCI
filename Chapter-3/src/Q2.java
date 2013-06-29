import java.util.Stack;

/**
 * 
 * @author yaoruhao
 * Question 3.2
 *
 */
public class Q2 {
	public Stack<Integer> objectStack;
	public Stack<Integer> minStack;
	
	public Q2() {
		objectStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int value) {
		objectStack.push(value);
		if (minStack.isEmpty() || value <= minStack.peek()) {
			minStack.push(value);
		}		
	}	
	public int pop() {
		int result = objectStack.pop();
		if (result == minStack.peek()) {
			minStack.pop();
		}		
		return result;
	}	
	public int min() {
		return minStack.peek();
	}	
	public static void main(String[] args) {
		Q2 testQ2 = new Q2();
		testQ2.push(7);
		testQ2.push(2);
		testQ2.push(2);
		testQ2.push(5);
		testQ2.push(1);
		for (int i = 0; i < 5; i++) {
			System.out.println(testQ2.min() + " " + testQ2.pop());
		}
	}

}
