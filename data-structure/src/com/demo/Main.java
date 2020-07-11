package com.demo;

public class Main {
	public static void main(String[] args) {
//		ArrayListTest();
		LinkedListTest();
	}

	public static void LinkedListTest() {
		List<Integer> list = new LinkedList<Integer>();
		list.add(20);
		list.add(0, 10);
		list.add(30);
		list.add(list.size(), 40);
		
		list.remove(1);
		System.out.print(list);
	}
	
	/* 动态数组 */
	public static void ArrayListTest() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(new Person(20, "Rack"));
		persons.add(new Person(30, "Rose"));
		persons.set(1, new Person(4, "lili"));
		persons.add(null);
		int index = persons.indexOf(null);
		System.out.print(index);
		System.out.print(persons);
		
		List<Object> people = new ArrayList<>();
		people.add(1);
		people.add("12");
		people.add(new Person(20, "haha"));
		System.out.print(people);
		
//		ArrayList list = new ArrayList();
//		list.add(11);
		
		
//		list.add(22);
//		list.add(33);
//		list.add(44);
//		list.add(55);
//		
//		list.set(3,  80);
//		
//		for(int i = 0; i < 30; i++) {
//			list.add(i);
//		}
//		
//		// 断言测试
//		Assert.test(list.get(3) == 80);
//		// 打印测试
//		System.out.println(list);
		
	}
}
