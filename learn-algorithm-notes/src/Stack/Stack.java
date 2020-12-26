package Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 下压堆栈（链表实现）
// 可以处理任意类型的数据；
// 所需的空间总是和集合的大小成正比；
// 操作所需的时间总是和集合的大小无关。
public class Stack<Item> implements Iterable<Item> {
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
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Item peek () {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
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
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack");
    }
}
