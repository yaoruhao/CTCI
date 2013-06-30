/**
 * 
 * @author yaoruhao
 * Question 5.8
 *
 */
public class Q8 {

	public void drawLine(byte [] screen, int width, int x1, int x2, int y) {
		int startOffset = x1 % 8;
		int firstFullByte = x1 / 8;
		if (startOffset != 0) {
			firstFullByte++;
		}
		int endOffset = x2 % 8;
		int lastFullByte = x2 / 8;
		if (endOffset != 7) {
			lastFullByte--;
		}
		for (int i = width/8*y + firstFullByte; i <= width/8*y + lastFullByte; i++) {
			screen[i] = (byte) 0xff;
		}
		byte startMask = (byte) (0xff >> startOffset);
		byte endMask = (byte) ~(0xff >> endOffset + 1);
		if (firstFullByte == lastFullByte) {
			screen[width/8*y + x1/8] |= (byte) (startMask | endMask);
		} else {
			if (startOffset != 0) {
				screen[width/8*y + x1/8] |= startMask;
			}
			if (endOffset != 7) {
				screen[width/8*y + x2/8] |= endMask;
			}			
		}
	}
}
