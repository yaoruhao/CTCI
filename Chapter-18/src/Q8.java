import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 18.8: Use tree to store same prefix words. Match them recursively.
 *
 */
public class Q8 {
	public class Node{
		char value;
		boolean hasWords;
		LinkedList<Node> childList;
	}
	
	public void findStrings(Node root, String str, int pos, String matchedStr) {
		if (pos >= str.length() || root == null) {
			return;
		}
		if (root.value != str.charAt(pos)) {
			return;
		}
		if (root.hasWords) {
			System.out.println(matchedStr + str.charAt(pos));
		}
		for (Node child : root.childList) {
			findStrings(child, str, pos + 1, matchedStr + root.value);
		}
	}
	
	public void findString(LinkedList<Node> forrest, String str) {
		for (Node root : forrest) {
			for (int i = 0; i < str.length(); i++) {
				findStrings(root, str, i, "");
			}
		}
	}

}
