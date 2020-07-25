package nodeList;

// 单向链表
public class singleNodeList<E> {
    private int size = 0;   // 元素的数量
    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
    // 元素的数量
    public int size() {
        return size;
    }

    // 
    public boolean isEmpty() {
        return size == 0;
    }
}