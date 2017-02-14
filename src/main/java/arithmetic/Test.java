package arithmetic;

/**
 * Created by Liuqi
 * Date: 2017/2/14.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 循环递归算法
 */
public class Test {
    public static void main(String[] args) {
        String[] arr = new String[]{"1", "2", "3", "4"};
        listAll(Arrays.asList(arr), "");
    }

    public static void listAll(List candidate, String prefix) {
        if (candidate.isEmpty()) {
            System.out.println(prefix);
        }
        for (int i = 0; i < candidate.size(); i++) {
            List temp = new LinkedList(candidate);
            listAll(temp, prefix + temp.remove(i));
        }
    }
}
