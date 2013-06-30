/**
 * 
 * @author yaoruhao
 * Question 4.8
 *
 */
public class Q8 {

	public boolean isSubTree(BinaryTreeNode t1, BinaryTreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 == null || t2 == null) {
			return false;
		}
		if (t1.value == t2.value) {
			if (isSubTree(t1.leftChild, t2.leftChild) && isSubTree(t1.rightChild, t2.rightChild)) {
				return true;
			}
		}
		if (isSubTree(t1.leftChild, t2)) {
			return true;
		}
		if (isSubTree(t1.rightChild, t2)) {
			return true;
		}
		return false;
	}
}
