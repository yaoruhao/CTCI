/**
 * 
 * @author yaoruhao
 * Question 17.1
 *
 */
public class Q1 {

	public void swap(int a, int b){
		System.out.println("Before swap: a="+ a +" b=" + b);
		b = a + b;
		a = b - a;
		b = b - a;
		System.out.println("After swap: a="+ a +" b=" + b);
	}
	public static void main(String[] args) {
		Q1 testQ1 = new Q1();
		testQ1.swap(1, -2);

	}

}
