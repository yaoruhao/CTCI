import java.util.Iterator;

/**
 * 
 * @author yaoruhao
 * Question 14.6
 *
 */
public class Q6<T> implements Iterable<T>{
	private T[] items;
	private int head = 0;
	public Q6(int capacity) {
		items =  (T[]) new Object[capacity];
	}
	public int getIndex(int originIndex){
		return (head + originIndex + items.length) % items.length;
	}
	public void rotate(int n) {
		head = getIndex(n);
	}
	public T get(int i) {
		if (i < 0 || i > items.length) {
			throw new IndexOutOfBoundsException();
		}
		return items[getIndex(i)];
	}
	public void set(T elem, int i) {
		items[getIndex(i)] = elem;
	}
	@Override
	public Iterator<T> iterator() {
		return new Q6Iterator<>(this);
	}
	private class Q6Iterator<TI> implements Iterator<TI>{
		
		public Q6Iterator (Q6<TI> array ) {
			_array = array.items;
		}
		@Override
		public boolean hasNext() {
			return _current < _array.length;
		}

		@Override
		public TI next() {
			return _array[getIndex(_current++)];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		private TI [] _array;
		private int _current = 0;
	}
	public static void main(String[] args) {
		Q6<Integer> testQ6 = new Q6<>(10);
		for (int i = 0; i < 10; i++) {
			testQ6.set(i, i);
		}
		testQ6.rotate(-3);
		for (Integer integer : testQ6) {
			System.out.println(integer);
		}
	}
}
