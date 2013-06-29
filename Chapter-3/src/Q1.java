/**
 * 
 * @author yaoruhao
 * Question 3.1 : implement 3 stacks in one array.
 *
 */
public class Q1 {
	class Node {
		int tag;
		Object value;
		public Node(int tag, Object value) {
			this.tag = tag;
			this.value = value;
		}
	}
	private Node []objectArray;
	private int capacity;
	private int currentCount;
	private int []headPointer;
	private int []tailPointer;
	public Q1(int capacity) {
		objectArray = new Node[capacity];
		this.capacity = capacity;
		this.currentCount = 0;
		headPointer = new int[3];
		tailPointer = new int[3];
		for (int i = 0; i < 3; i++) {
			headPointer[i] = -1;
			tailPointer[i] = -1;
		}
	}
	//Just shift the headpointer and the following elements for stackNum to one step right.
	private void shiftRight(int stackNum) {
		
	}
	public boolean push(Object value, int stackNum) {
		if (currentCount >= capacity) {
			return false;
		}
		int spotToInsert = 0;
		if (headPointer[stackNum] == -1) {
			spotToInsert = stackNum * capacity / 3;
		} else {
			spotToInsert = (tailPointer[stackNum] + 1) % capacity;
		}
		//find a spot
		while (objectArray[spotToInsert] != null && spotToInsert != headPointer[stackNum]) {
			spotToInsert = (spotToInsert + 1) % capacity;
		}
		//need to shift headpointer and its after corresponding element right.
		if (spotToInsert == headPointer[stackNum]) {
			shiftRight(stackNum);
		}
		objectArray[spotToInsert] = new Node(stackNum, value);
		tailPointer[stackNum] = spotToInsert;
		currentCount++;
		return true;
	}
	
	public Object pop(int stackNum) {
		if (headPointer[stackNum] == -1) {
			return null;
		}
		Object resultObject = objectArray[tailPointer[stackNum]];
		currentCount--;
		objectArray[tailPointer[stackNum]] = null;
		if (headPointer[stackNum] == tailPointer[stackNum]) {
			headPointer[stackNum] = -1;
			tailPointer[stackNum] = -1;
		} else {
			while (objectArray[tailPointer[stackNum]] == null || objectArray[tailPointer[stackNum]].tag != stackNum) {
				tailPointer[stackNum]--;
			}
		}		
		return resultObject;
	}

}
