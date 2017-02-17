package exam;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liuqi
 * Date: 2017/2/17.
 */

/**
 * 判断一组数是否可以围成一个多边形
 */
public class Test2 {
    static List<Integer> list = new LinkedList<Integer>();

    public static boolean doJudge(List<Integer> list) {
        if (list.size() < 3) {
            return false;
        }
        int max = 0;
        int other_len = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                other_len += max;
                max = list.get(i);
            } else {
                other_len += list.get(i);
            }
        }
        return other_len > max;
    }

    public static boolean add(int i) {

        list.add(i);
        if (list.size() < 3) {
            return false;
        }

        return doJudge(list);
    }

    public static boolean remove(List<Integer> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                list.remove(i);
                break;
            }
        }
        return doJudge(list);

    }

    public static void main(String[] args) {

      /*  list.add(5);
        list.add(5);
        list.add(5);*/
        /*System.out.println(doJudge(list));*/
  /*      System.out.println(add(list, 3));
        System.out.println(add(list, 5));
        System.out.println(add(list, 4));
        System.out.println(add(list, 4)); */
        System.out.println(add(3));
        System.out.println(add(5));
        System.out.println(add(4));
        System.out.println(add(4));
        System.out.println(doJudge(list));
        System.out.println(remove(list, 4));
        System.out.println(list.isEmpty());
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
