/**
 * 
 * @author yaoruhao
 *
 */
public class Pair {
	int height;
	int weight;
	public Pair(int h, int w) {
		height = h;
		weight = w;
	}
	@Override
	public String toString() {
		return "[h=" + height + ", w=" + weight + "]";
	}
	
	public boolean isLessThan(Pair other){
		if (height < other.height && weight < other.weight) {
			return true;
		}
		return false;
	}

}
