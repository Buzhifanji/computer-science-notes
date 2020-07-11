package com.demo;

// 抽取链表公共代码
// 抽象类
public abstract class AbstractList<E> implements List<E> {
	// 元素数量
	protected int size;
	
	/* 元素的数量 */
	public int size() {
		return size;
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
	
	protected void outOfBound(int index) {
		throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
	
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBound(index);
		}
	}
	
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBound(index);
		}
	}
}
