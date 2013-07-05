import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author yaoruhao 
 * Question 9.10: Compare the textbook solution with mine.
 * The textbook may be wrong
 * 
 */
public class Q10 {
	Box[] boxes;

	public class Box {
		int height;
		int width;
		int depth;
		boolean used;
		public Box(double h, double w, double d) {
			height = (int) h;
			width = (int) w;
			depth = (int) d;
			used = false;
		}

		@Override
		public String toString() {
			return "Box [height=" + height + ", width=" + width + ", depth="
					+ depth + "]";
		}
		public boolean canBeAbove(Box b) {
			if (b == null) {
				return true;
			}
			if (width < b.width && height < b.height && depth < b.depth) {
				return true;
			}
			return false;		
		}

	}

	public int findMaxHeight(int curH, int curW, int curD) {
		int maxHeight = 0;
		for (int i = 0; i < boxes.length; i++) {
			if (!boxes[i].used && boxes[i].height < curH
					&& boxes[i].depth < curD && boxes[i].width < curW) {
				boxes[i].used = true;
				int tempHeight = findMaxHeight(boxes[i].height, boxes[i].width,
						boxes[i].depth);
				boxes[i].used = false;
				if (tempHeight + boxes[i].height > maxHeight) {
					maxHeight = tempHeight + boxes[i].height;
				}
			}
		}
		return maxHeight;
	}
	public static ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> stack_map) {
		if (bottom != null && stack_map.containsKey(bottom)) {
			return stack_map.get(bottom);
		}
		
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackDP(boxes, boxes[i], stack_map);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}		
		
		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);
		}
		stack_map.put(bottom, max_stack);
		
		return (ArrayList<Box>)max_stack.clone();
	}
	public static int stackHeight(ArrayList<Box> boxes) {
		if (boxes == null) {
			return 0;
		}
		int h = 0;
		for (Box b : boxes) {
			h += b.height;
		}
		return h;
	}

	public Q10() {
		boxes = new Box[4];
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = new Box(Math.random() * 10 + i, Math.random() * 10
					+ i, Math.random() * 10 + i);
			System.out.println(boxes[i]);
		}
		System.out.println(findMaxHeight(Integer.MAX_VALUE, Integer.MAX_VALUE,
				Integer.MAX_VALUE));
		ArrayList<Box> stack = createStackDP(boxes, null, new HashMap<Box, ArrayList<Box>>());
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.println(b.toString());
		}
	}

	public static void main(String[] args) {
		Q10 testQ10 = new Q10();

	}

}
