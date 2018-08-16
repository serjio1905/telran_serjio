
public class RecursionTestAppl {

	public static void main(String[] args) {
//		System.out.println(fact(4));
//		System.out.println(pow(10,3));
//		int ar[] = {1,2,3,10};
//		System.out.println(sum(ar));
		System.out.println(pow(9, 4));
	}
	
	private static int square(int i) {
		// TODO no multiple, no loops, no additional functions
		if(i == 0) return i;
		return i + i + square(i-1) - 1;
	}

	public static long fact(int n) {
		if(n < 2) return 1;
		return n * fact(--n);
	}
	
	public static Integer pow(int number, int p) {
//		if(p < 1) return null;
//		if(p == 1) return number;
//		return number * pow(number, --p);
		//TODO no multiple, no loops
		if(p == 1) return number;
		int n = sum(number, p);
		return sum(number, n);
	}

	public static int sum(int number, int i) {
		if(i == 1) return number;
		i--;
		return number + sum(number, i);
	}
	
	public static int sum(int[] ar) {
		return sum(ar, 0);
	}
	
	private static int sum(int[] ar, int i) {
		if(i >= ar.length)
			return 0;
		return ar[i] + sum(ar, ++i);
	}
	
}
