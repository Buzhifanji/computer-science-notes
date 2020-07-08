package com.demo;

import com.demo.TimeTool.Task;

// 时间复杂度
public class Complexity {
	
	// 测试运行所需要的时间
	public static void main(String[] args) {
		TimeTool.test("fib1", new Task() {
			
			@Override
			public void execute() {
				System.out.println(fib1(30000));
			}
		});

	}
	
	
	// 平方阶O(n²)
	// O(2^n)
	public static int fib1(int n) {
		if (n <= 1) return n;
		return fib1(n - 1) + fib1(n - 2);
	}
	
	// 线性阶O(n)
	// O(n)
	public static int fib2(int n) {
		if (n <= 1) return n;
		
		int first = 0;
		int second = 1;
		for(int i = 0; i < n -1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	
	// 常数阶O(1)
	public static void test1(int n) {
		// 汇编指令
		
		// 1
		if (n > 10) { 
			System.out.println("n > 10");
		} else if (n > 5) { // 2
			System.out.println("n > 5");
		} else {
			System.out.println("n <= 5"); 
		}
		
		// 1 + 4 + 4 + 4
		for (int i = 0; i < 4; i++) {
			System.out.println("test");
		}
		
		// 140000
		// O(1)
		// O(1)
	}
	
	// 线性阶O(n)
	public static void test2(int n) {
		// O(n)
		// 1 + 3n
		for (int i = 0; i < n; i++) {
			System.out.println("test");
		}
	}
	
	// 线性阶O(n)
	public static void test3(int n) {
		// 1 + 2n + n * (1 + 3n)
		// 1 + 2n + n + 3n^2
		// 3n^2 + 3n + 1
		// O(n^2)
		
		// O(n)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("test");
			}
		}
	}

	// 线性阶O(n)
	public static void test4(int n) {
		// 1 + 2n + n * (1 + 45)
		// 1 + 2n + 46n
		// 48n + 1
		// O(n)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.println("test");
			}
		}
	}
	
	// 对数阶O(logn)
	public static void test5(int n) {
		// 8 = 2^3
		// 16 = 2^4
		
		// 3 = log2(8)
		// 4 = log2(16)
		
		// 执行次数 = log2(n)
		// O(logn)
		while ((n = n / 2) > 0) {
			System.out.println("test");
		}
	}

	// 对数阶O(logn)
	public static void test6(int n) {
		// log5(n)
		// O(logn)
		while ((n = n / 5) > 0) {
			System.out.println("test");
		}
	}

	// 线性对数阶O(nlogn)
	public static void test7(int n) {
		// 1 + 2*log2(n) + log2(n) * (1 + 3n)
		
		// 1 + 3*log2(n) + 2 * nlog2(n)
		// O(nlogn)
		for (int i = 1; i < n; i = i * 2) {
			// 1 + 3n
			for (int j = 0; j < n; j++) {
				System.out.println("test");
			}
		}
	}
	
}