package nodeList;
import tool.Assert;

public class SingleNodeListTest {
    public static void main(String[] args) {
        test();
        testReverListRecursion();
        testReverListFor();
    }

    public static void test() {
        SingleNodeList<Integer> list = new SingleNodeList<Integer>();
        // 10, 5, 49
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.set(1, 5);
        list.add(49);
        list.remove(2);
        Assert.test(list.get(2) == 49);
        Assert.test(list.size() == 3);
    }

    public static void testReverListRecursion() {
        SingleNodeList<Integer> node = new SingleNodeList<Integer>();
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        node.add(6);
        node.reverListRecursion();
    }

    public static void testReverListFor() {
        SingleNodeList<Integer> node = new SingleNodeList<Integer>();
        node.add(10);
        node.add(20);
        node.add(30);
        node.add(40);
        node.add(50);
        node.add(60);
        node.reverListByFor();
    }
}