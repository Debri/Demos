package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Liuqi
 * Date: 2017/3/30.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();
            boolean b = doCompare(str1, str2);
            System.out.println(b);
        }
    }

    public static boolean doCompare(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        for (char c : chars1) {
            set1.add(c);
        }
        for (char c : chars2) {
            set2.add(c);
        }
        if (set1.containsAll(set2) && set2.containsAll(set1)) {
            return true;
        }
        return false;
    }
}
