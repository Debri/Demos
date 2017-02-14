package arithmetic;

import java.util.*;

/**
 * Created by Liuqi
 * Date: 2017/2/14.
 */

/**
 * 对一字符串进行统计字符数量并且排序
 * 计算出现次数最多的那个字母及次数
 */
public class Test1 {
    public static void main(String[] args) {
        String input="asdygkjhgberkjutgfklihjgdscbjhfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        doString(input);
    }
    public  static  void doString(String input) {
        char[] chars = input.toCharArray();
        List<String> list = new ArrayList<String>();
        TreeSet set = new TreeSet();

        for (int i = 0; i < chars.length; i++) {
            list.add(String.valueOf(chars[i]));
            set.add(String.valueOf(chars[i]));
        }
        System.out.println("set" +set);
        Collections.sort(list);
        System.out.println("list" +list);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        input = sb.toString();
        System.out.println("input" +input);
        int max = 0;
        String maxString = "";
        List<String> maxList = new ArrayList<String>();
        Iterator ite = set.iterator();
        while (ite.hasNext()) {
            String os = (String) ite.next();
            int begin = input.indexOf(os);
            int end = input.lastIndexOf(os);
            int value = end - begin + 1;
            if (value > max) {
                max = value;
                maxString = os;
                maxList.add(os);
            } else if (value == max) {
                maxList.add(os);
            }
        }
        int index=0;
        for (int i=0;i<maxList.size();i++){
            if (maxList.get(i).equals(maxString)){
                index=1;
                break;
            }
        }
        System.out.println("max data");
        for (int i=0 ;i< maxList.size();i++){
            System.out.print(maxList.get(i)+"  ");
        }
        System.out.println();
        System.out.println("max "+ max);

    }
}
