package exam;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Liuqi
 * Date: 2017/3/30.
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(doJudge(input));

    }

    public static boolean doJudge(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}
