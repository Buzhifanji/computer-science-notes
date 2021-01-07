package charpterOnePracitce;

import Queue.Queue;
import Stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * algs-1.3.10
 * 题目: 编写一个过滤器InfixToPostfix，将算术表达式由中序表达式转为后序表达式。
 * 例子: 中序表达式  (2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )       后续表达式: 2 3 4 + 5 6 * * +
 *
 *  思路:除左括号外依次压入栈中,遇到 ) 出栈
 *  left                            right
 *  2 + 3 + 4                       2 + 3 4 +               // 3 4 + 作为一个整体
 *  2 + 3 4 + * 5 * 6               2 + 3 4 + * 5 6 *       // 5 6 * 作为一个整体
 *  2 + 3 4 + * 5 6 *               2 + 3 4 + 5 6 * *
 *  2 + 3 4 + 5 6 * *               2 3 4 + 5 6 * * +
 *
 *  双栈思路
 *  左栈                      右栈
 *  2                          +
 *  2 3 4                      + +
 *  2 3 4 +                    +
 *  2 3 4 + 5 6                + *  *
 *  2 3 4 + 5 6 *              + *
 *  2 3 4 + 5 6 * * +
 */

public class InfixToPostfix {

    public static void main(String[] args) {
        twoStack();
//        oneStack();
    }
    private static void oneStack() {
        Stack<String> stack = new Stack<String>();
        StdOut.println("...输入exit退出程序...");
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("exit")) {
                StdOut.println("...程序即将退出...");
                break;
            }
            if (item.equals(")")) {
                String num2 = stack.pop();
                String operator = stack.pop();
                String num1 = stack.pop();
                stack.push(num1 + " " + num2 + " " + operator);
            } else if (item.equals("(")) {
                continue;
            } else {
                stack.push(item);
            }
        }
        StdOut.print(stack.pop());
    }
    private static void twoStack() {
        Queue<String> queue = new Queue<String>();
        Stack<String> stack = new Stack<String>();
        StdOut.println("...输入exit退出程序...");
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("exit")) {
                StdOut.println("...程序即将退出...");
                break;
            }
            if (item.equals(")")) {
                queue.enqueue(stack.pop());
            } else if (item.equals("(")) {
                continue;
            } else if (item.equals("+") || item.equals("-") || item.equals("*") ||item.equals("/")) {
                stack.push(item);
            } else {
                queue.enqueue(item);
            }
        }
        for(String s : queue) {
            StdOut.print(s);
        }
    }
}


