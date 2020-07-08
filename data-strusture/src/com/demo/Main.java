package com.demo;

public class Main {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		
		list.set(3, 88);
		
//		list.add(1, 100);
//		list.add(1, 110);
//		list.remove(list.size() -1);
		System.out.println(list);
	}
}
