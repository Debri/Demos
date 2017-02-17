package exam;

import java.util.*;

/**
 * Created by Liuqi
 * Date: 2017/2/17.
 */

/**
 * 编程题目
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。这样每个字符串
 * 就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。 n
 * 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 */

/**
 * 竟然花了我一个小时。。。。。
 */
public class Test1 {
    static Map<Character, Long> map = new HashMap<Character, Long>();

    static {
        for (char i = 'A'; i <= 'F'; i++) {
            map.put(Character.valueOf(i), 0L);
        }
    }

    public static void doTest(String[] arr, int n) {
        if (n > 50) {
            return;
        }
        char[] temp;
        int len = arr.length;
        for (int i = 0; i < n; i++) {
            temp = arr[i].toCharArray();
            /*for (int x = 0; x < temp.length; x++) {
                System.out.println(temp[x]);
            }*/
            if (temp.length > 12) {
                break;
            } else {
                for (int j = 0; j < temp.length; j++) {
                    double d = Math.pow(10, (len - j));
                    long l = map.get(temp[j]);
                    map.put(temp[j], (long) d + l);
                    System.out.println(temp[j]);
                }
            }
        }
    }

    private static void doSortByValue(Map map) {
        double result = 0;
        int x = 9;
        List<Map.Entry<Character, Long>> list = new ArrayList<Map.Entry<Character, Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Long>>() {
            public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Map.Entry<Character, Long> mapping : list) {
            result += mapping.getValue().longValue() * x--;
            //System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
        System.out.println(result);
    }

    private static void doPrint(Map<Character, Long> map) {
        double result = 0;
        Iterator entries = map.entrySet().iterator();
        int i = 9;
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            result += ((Long) entry.getValue()).longValue() * i--;
            System.out.print(entry.getKey());
            System.out.print("  " + entry.getValue());
            System.out.println();
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String[] str = {"ABC", "BCA"};
        doTest(str, 2);
        doSortByValue(map);
       // doPrint(map);
    }
}
