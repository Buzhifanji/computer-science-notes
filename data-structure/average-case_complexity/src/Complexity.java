

public class Complexity {
	public static int fib(int n) {
		if(n <= 1) return n;
		int first = 0;
		int second = 1;
		for(int i = 0; i < n; i++) {
			int sum = first + second;
			second = first;
		}
		return second;
	}
	public static void main(String[] args) {
		TimeToll.check("fib", new Task())
	}
}
