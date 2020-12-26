package charpterOnePracitce;

import Stack.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 利用栈转换二进制
 */
public class BinarySystem {
    public static void main(String[] args) {
        int N = 50;
        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0) {
            stack.push(N % 2);  // n % 2得到n的二进制最低位上的值，0或者1
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
