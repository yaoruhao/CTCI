import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 3.3
 *
 */
public class Q3 {

	private LinkedList<LinkedList<Integer>> elemList;
	private int capacity;
	public Q3 (int capacity) {
		elemList = new LinkedList<LinkedList<Integer>>();
		this.capacity = capacity;
	}
	
	public void push(int value) {
		if (elemList.isEmpty()) {
			elemList.add(new LinkedList<Integer>());
		}
		LinkedList<Integer> listToPush = elemList.getLast();
		if (listToPush.size() > capacity) {
			listToPush = new LinkedList<Integer>();
			elemList.add(listToPush);
		}
		listToPush.add(value);		
	}
	
	//shift right bottom to left top iteraterly.
	//leave it blank for ease.
	public void adjustListFromIndex(int listIndex) {
		
	}
	
	public int popAtIndex(int popIndex) {
		int listIndex = popIndex / capacity;
		if (listIndex >= elemList.size()) {
			return -1;
		}
		int elemIndex = popIndex % capacity;
		LinkedList<Integer> listToPop = elemList.get(listIndex);
		int result = listToPop.get(elemIndex);
		listToPop.remove(elemIndex);
		adjustListFromIndex(listIndex);
		return result;
	}
	
	public int pop() {
		if (elemList.isEmpty()) {
			return -1;
		}
		LinkedList<Integer> listToPop = elemList.getLast();
		int resultValue = listToPop.removeLast();
		if (listToPop.isEmpty()) {
			elemList.removeLast();
		}
		return resultValue;
	}
	
	public static void main(String[] args) {
		Q3 testQ3 = new Q3(5);
		for (int i = 0; i < 31; i++) {
			testQ3.push(i);
		}
		for (int i = 0; i < 31; i++) {
			System.out.println(testQ3.pop());
		}
	}

}
