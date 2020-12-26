package Bag;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 背包是一种不支持从中删除元素的集合数据类型
// 它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素
// 使用Bag可以说明元素的处理顺序不重要
public class Bag<Item> implements Iterable<Item>  {
    private Node first = null;     // 栈顶（最近添加的元素)
    private int N = 0;      // 元素数量
    private class Node {    // 定义了结点的嵌套类
        Item item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null; // 或： N == 0
    }
    public int size() {
        return N;
    }
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    // 测试用例
    public static void main(String[] args) {
        Bag<String> s = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.toString() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack");
    }
}
