package dynamic_array;

public class Main {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		
//		list.add(1, 100);
		list.remove(5);
		System.out.println(list);
	}
}