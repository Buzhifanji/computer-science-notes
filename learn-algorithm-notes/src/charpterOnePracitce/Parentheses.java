package charpterOnePracitce;

import java.util.Scanner;
import java.util.Stack;

/**
 * 编写一个 Stack 的用例 Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整。
 * 例如，对于 [()]{}{()()} 程序应该打印 true，对于 [(]) 则打印 false。
 */
public class Parentheses {
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("...输入exit退出程序...");
        while (true) {
            if (scanner.hasNext()) {
                String input = scanner.nextLine();
                if ("exit".equals(input)) {
                    System.out.println("...程序即将退出...");
                    break;
                }
                System.out.println("...Your input :" + input + "...");
                System.out.println(isBalanced(input));
            }
        }
    }
    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == LEFT_BRACE || c == LEFT_BRACKET || c == LEFT_PAREN) {
                stack.push(c);
            }
            if (stack.isEmpty()) {
                return false;
            }
            if ((c == RIGHT_PAREN && stack.peek() == LEFT_PAREN)
                || (c == RIGHT_BRACE && stack.peek() == LEFT_BRACE)
                || (c == RIGHT_BRACKET && stack.peek() == LEFT_BRACKET)) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
