package charpterOnePracitce;

import Stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * algs-1.3.9
 * 题目:编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如: 给定输入：1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) => 你的程序应该输出：((1+2)*((3-4)*(5-6)))
 *
 * left                                         right
 * 1 + 2 )                                      (1 + 2 )                            // (1 + 2 ) 作为一个整体压入栈中
 * (1 + 2 ) * 3 - 4 )                           (1 + 2 ) * (3 - 4 )                 // * 和 (3 - 4 )  依次压入栈中
 * (1 + 2 ) * (3 - 4 )  * 5 - 6 )               (1 + 2 ) * (3 - 4 )  * (5 - 6 )     // * 和 5 - 6 )    依次压入栈中
 *  (1 + 2 ) * (3 - 4 )  * (5 - 6 ))            (1 + 2 ) * ((3 - 4 )  * (5 - 6 ))
 *  (1 + 2 ) * ((3 - 4 )  * (5 - 6 )))          ((1 + 2 ) * ((3 - 4 )  * (5 - 6 )))
 */



public class E_1_3_9 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        StdOut.println("...输入exit退出程序...");
        while (!StdIn.isEmpty()) {
            if (StdIn.hasNextLine()) {
                String item = StdIn.readString();
                if ("exit".equals(item)) {
                    StdOut.println("...程序即将退出...");
                    break;
                }

                if (item.equals(")")) {
                    String num2 = stack.pop();
                    String operator = stack.pop();
                    String num1 = stack.pop();
                    stack.push("( " + num1 + " " + operator + " " + num2 + " )");
                } else {
                    stack.push(item);
                }
            }
        }
        StdOut.print(stack.pop());
    }
}