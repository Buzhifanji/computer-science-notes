package arrayList;

// 动态数组
public class ArrayList<E> {
    private E[] elements;
    private int size = 0;   // 元素的数量
    private static final int DEFAULT_CAPATICY = 10; // 数组默认容量
    static final int ELEMENT_NOT_FOUND = -1;    // 没有找到元素统一返回-1

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPATICY) ? DEFAULT_CAPATICY : capacity;
        // new 是向堆空间申请内存
        elements = (E[]) new Object[capacity];
    }

    // 无参的构造函数   初始化为写入需要申请的空间数量的时候调用
    public ArrayList() {
        this(DEFAULT_CAPATICY);
    }

    // 清楚所有元素 
	public void clear() {
		for(int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}

    // 是否包含某个元素
    public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

    // 元素的数量
    public int size() {
        return size;
    }

    // 元素是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 添加到知道索引位置
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        // 从 size -1（数组是从0开始的） 到 index 往后挪到元素 
        for (int i = size -1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }
    // 往尾部添加
    public void add(E element) {
        add(size, element);
    }

    // 获取index位置的元素
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    // 设置index位置的元素
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    // 删除index位置的元素
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return old;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
	 * 保证要有capacity的容量
	 * @param capacity
	 */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 扩容1.5倍， 不直接乘于1.5 是为了 不会浮点失真
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为："  + newCapacity);
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

    // 超出容量时候报错信息
    protected void outOfBound(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // 检查是否超出容量(不用于增加元素时候检查)
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBound(index);
        }
    }

    // 增加元素检查是否超出容量
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBound(index);
        }
    }
}