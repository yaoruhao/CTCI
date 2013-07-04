import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author yaoruhao
 * Question 8.10
 *
 */
public class Q10 {

	private ArrayList<LinkedList<Object>> storeList;
	public boolean contains(Object object){
		int hashValue = object.hashCode() % storeList.size();
		if (storeList.get(hashValue) == null) {
			return false;
		}
		LinkedList<Object> additionalList = storeList.get(hashValue);
		for (Object tempObject : additionalList) {
			if (tempObject == object) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(Object object){
		if (contains(object)) {
			return false;
		}
		int hashValue = object.hashCode() % storeList.size();
		LinkedList<Object> additonalList = storeList.get(hashValue);
		if (additonalList == null) {
			additonalList = new LinkedList<Object>();
			storeList.set(hashValue, additonalList);
		}
		additonalList.add(object);
		return true;
	}
	public boolean remove(Object object){
		if (!contains(object)) {
			return false;
		}
		int hashValue = object.hashCode() % storeList.size();
		LinkedList<Object> additionalList = storeList.get(hashValue);
		return additionalList.remove(object);
	}
	public Q10 (int capacity) {
		storeList = new ArrayList<LinkedList<Object>>(capacity);
		for (int i = 0; i < capacity; i++) {
			storeList.add(null);
		}
	}

}
