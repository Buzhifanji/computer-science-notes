package arrayList;

import tool.Assert;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "Jack"));
		persons.add(new Person(20, "Rack"));
		persons.add(new Person(30, "Rose"));
		persons.set(1, new Person(4, "lili"));
        persons.add(null);
        int index = persons.indexOf(null);
		System.out.print(index);
		System.out.print(persons);
    }

    public static void AssertTest() {
        ArrayList<Integer>  list = new ArrayList<>();

        list.add(1);
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
