package Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

// 下压（LIFO）栈（能够动态调整数组大小的实现）
// 缺点：某些push()和pop()操作会调整数组的大小：这项操作的耗时和栈大小成正比
public class ResizingArrayStack<Item> implements Iterable {
    private static final int INIT_CAPACITY = 8;
    private Item[] a;   // 栈元素
    private int n;

    /**
     * 初始化空栈
     */
    public ResizingArrayStack() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    /**
     * 栈是否为空
     * @return true代表为空，否则不为空
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * 返回栈中的元素个数
     * @return 返回栈中的元素个数
     */
    public int size() {
        return n;
    }
    /**
     * 复制全部元素到一个新的内存中
     */
    private void resize(int capacity) {
        assert capacity >= n;

        Item[] copy = (Item[])  new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    /**
     * 添加一个元素到栈中
     * @param item
     */
    public void push(Item item) {
        if (n == a.length) {
            resize(2 * a.length);   // 2 倍扩容
        }
        a[n++] = item;
    }

    /**
     * 删除栈中一个元素并返回
     * @return  返回删除的元素
     * @throw   当栈中为空时，抛出 java.util.NoSuchElementException 异常
     */
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = a[n-1];
        a[n-1] = null;  // 防止内存泄漏（对象游离）
        n--;
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);   // 2 倍缩容
        }
        return item;
    }

    /**
     *
     * @return 当前栈的迭代器，让元素 后进先出 进行迭代
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    // 迭代器，未实现 remove 方法,因为它是可选的
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;
        public ReverseArrayIterator() {
            i = n -1;
        }
        public boolean hasNext() {
            return i >= 0;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[i--];
        }

    }

    /**
     * 单元测试 {@code Stack} 数据类型
     * @param args
     */
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}

