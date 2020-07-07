package dynamic_array;

public class ArrayList {
	private int size;
	private int[] elements;
	private static final int DEFAULT_CAPATICY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;

	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPATICY) ? DEFAULT_CAPATICY : capaticy;
		elements = new int[capaticy];
	}

	// 无参的构造函数
	public ArrayList() {
		this(DEFAULT_CAPATICY);
	}

	/* 元素的数量 */
	public int size() {
		return size;
	}

	/* 清楚所有元素 */
	public void clear() {
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	
	public boolean contains(int element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	  
	}
	  
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(int element) {
		add(size, element);
	}
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, int element) {
		rangeCheckForAdd(index);
		for(int i = size -1; i >= index; i--) {
			elements[i + 1]= elements[i];
		}
		elements[index] = element;
		size++;
	}

	/**
	 * 获取index位置的元素
	 * 
	 * @param index
	 * @return
	 */
	public int get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	/**
	 * 设置index位置的元素
	 * 
	 * @param index
	 * @param element
	 * @return 原来的元素ֵ
	 */
	public int set(int index, int element) {
		rangeCheck(index);
		int old = elements[index];
		elements[index] = element;
		return old;
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public int remove(int index) {
		rangeCheck(index);
		int old = elements[index];
		for(int i = index; i < size; i++) {
			elements[i] = elements[i+1];
		}
		size--;
		return old;
	}
	
	/**
	 * 查看元素的索引
	 * 
	 * @param element
	 * @return
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public String toString() {
		// size = 3, [10, 9, 8]
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(": [");
		for(int i = 0; i < size; i++) {
			if(i != 0) {
				string.append(",");
			}
			string.append(elements[i]);
//			if(i != size - 1) {
//				string.append(",");
//			}
		}
		string.append("]");
		return string.toString();
	}
	
	private void outOfBound(int index) {
		throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBound(index);
		}
	}
	
	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBound(index);
		}
	}
	
	/*
	 * 
	 * public void add(int index, int element) {
	 * 
	 * }
	 * 
	 * public remove() {
	 * 
	 * }
	 * 
	 */
}
