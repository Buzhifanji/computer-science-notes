package com.demo;

// 链表
public class LinkedList<E> extends AbstractList<E>  {
	private Node<E> first;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	public void clear() {
		 size = 0;
		 first = null;		
	}

	public void add(int index, E element) {
		// 处理边界 0
		if(index == 0) {
			first = new Node<>(element, first);
		} else {
			// 获取上一个节点
			Node<E> prev = node(index -1);	
			// 创建新的节点,并且把上一个节点的next指向该新的节点
			prev.next = new Node<>(element, prev.next);
		}
		size++;
	}

	public E get(int index) {
		return node(index).element;
	}

	public E set(int index, E element) {
		// 找到节点位置
		Node<E> node = node(index);
		// 取出旧节点元素
		E old = node.element;
		// 新元素覆盖旧节点
		node.element = element;
		return old;
	}

	public E remove(int index) {
		Node<E> node = first;
		if(index == 0) {
			first = first.next.next;
		} else {
			Node<E> prev = node(index - 1);
			node = prev.next;
			prev.next = node.next;
		}
		size--;
		return node.element;
	}

	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for(int i = 0; i < size; i++) {
				if(node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
			for(int i = 0; i < size; i++) {
				if(node.element == element) {
					return i;
				}
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	@Override
	public String toString() {
		//exemple: size = 3, [10, 9, 8]
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(": [");
		Node<E> node = first;
		for(int i = 0; i < size; i++) {
			if(i != 0) {
				string.append(",");
			}
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		
		// 第一个节点
		Node<E> node = first;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	// 反转链接——递归
	// private Node<E> reverseListByRecursion(Node<E> head) {
	// 	if(head == null || head.next == null) {			// 链表为空直接返回，而head->next为空是链表只有一个元素
	// 		return head;
	// 	}
	// 	Node<E> newHead = reverseListByRecursion(head.next);	//一直循环到链尾 
	// 	head.next.next = head;							// 翻转链表的指向
	// 	head.next = null;								//记得赋值NULL，防止链表错乱
	// 	return newHead;								//新链表头永远指向的是原链表的链尾
	// }
	
	// // 返回链表——非递归
	// private Node<E> reverseListByFor(Node<E> head) {
	// 	if(head == null || head.next == null) {
	// 		return head;
	// 	}
	// 	Node<E> newHead = null;
	// 	while(head != null) {				//一直迭代到链尾
	// 		Node<E> temp = head.next;		//暂存head下一个地址，防止变化指针指向后找不到后续的数
	// 		head.next = newHead;			 //head->next指向前一个空间
	// 		newHead = head;					//新链表的头移动到head，扩长一步链表
	// 		head = temp;					////head指向原始链表p指向的下一个空间
	// 	}
	// 	return newHead;
	// }
}
