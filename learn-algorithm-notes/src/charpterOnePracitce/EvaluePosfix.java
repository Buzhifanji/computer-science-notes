package charpterOnePracitce;

import Queue.Queue;
import Stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluePosfix {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new Queue<String>();
        StdOut.println("...输入exit退出程序...");
        // 将算术表达式由中序表达式转为后序表达式。
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
        // 计算后序表达式
        while (!queue.isEmpty()) {
            String item = queue.dequeue();
            if (item.equals("+") || item.equals("-") || item.equals("*") ||item.equals("/")) {
                // 只考虑整数
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                String result = "";
                if (item.equals("+")) {
                     result = String.valueOf(num1 + num2) ;
                } else if (item.equals("-")) {
                    // 只考虑整数
                     result = String.valueOf(num1 - num2) ;
                } else if (item.equals("*")) {
                    // 只考虑整数
                     result = String.valueOf(num1 * num2) ;
                } else if (item.equals("/")) {
                    // 只考虑整数
                     result = String.valueOf(num1 / num2) ;
                }
                if (!result.equals("")) {
                    stack.push(result);
                }
            } else {
                stack.push(item);
            }
        }
        StdOut.print(stack.pop());
    }
}
