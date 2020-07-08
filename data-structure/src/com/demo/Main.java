package com.demo;

public class Main {
	public static void main(String[] args) {
		ComplexityTest();
	}

	/* 动态数组 */
	public static void ComplexityTest() {
		ArrayList list = new ArrayList();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		
		list.set(3,  80);
		
		for(int i = 0; i < 30; i++) {
			list.add(i);
		}
		
		// 断言测试
		Assert.test(list.get(3) == 80);
		// 打印测试
		System.out.println(list);
		
	}
}