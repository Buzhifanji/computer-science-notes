package com.demo;

// 动态数组
public class ArrayList<E> {
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPATICY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;

	@SuppressWarnings("unchecked")
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPATICY) ? DEFAULT_CAPATICY : capaticy;
		// new 是向堆空间申请内存
		elements = (E[]) new Object[capaticy];
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
		for(int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	  
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size + 1);
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
	public E get(int index) {
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
	public E set(int index, E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}

	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		rangeCheck(index);
		E old = elements[index];
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
	public int indexOf(E element) {
		if(element == null) {
			for(int i = 0; i < elements.length; i++) {
				if(elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i] == element) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public String toString() {
		//exemple: size = 3, [10, 9, 8]
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
	/**
	 * 保证要有capacity的容量
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if(oldCapacity >= capacity) return;
		
		// 扩容1.5倍， 不直接乘于1.5 是为了 不会浮点失真
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newELements = (E[]) new Object[newCapacity];
		for(int i = 0; i < size; i++) {
			newELements[i] = elements[i];
		}
		elements = newELements;
		System.out.println(oldCapacity + "扩容为："  + newCapacity);
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

}
