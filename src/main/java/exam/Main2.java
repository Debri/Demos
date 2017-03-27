package exam;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Liuqi
 * Date: 2017/3/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[] chars = input.toCharArray();
        System.out.println(chars.length);
        Stack<Character> stack = new Stack<Character>();
        int result = chars[0]-48;
        for (int i = 1; i < chars.length; i++) {
          /*  if (chars[i] >= 48 && chars[i] <= 57) {
                stack.push(chars[i]);
            } else */if (chars[i] == 43) {
                result += chars[++i]-48;
            } else if (chars[i] == 42) {
                result *= (chars[++i]-48);
            } else if (chars[i] == 45) {
                result -= (chars[++i]-48);
            } else {
                i++;
            }

        }
        System.out.println(result);
    }
}
