package exam1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/4/1.
 */
public class Main2 {
    static List<String> list;
    static String[] str3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] array1 = scanner.nextLine().toCharArray();
        char[] array2 = scanner.nextLine().toCharArray();
        str3 = scanner.nextLine().split(" ");
        list = Arrays.asList(str3);

        doCompare(array1, array2);


    }

    public static void doCompare(char[] chars1, char[] chars2) {
        int n = 0;
        if (chars1.length != chars2.length) {
            return;
        }
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
               // System.out.println(chars1[i]);
                chars1[i] = chars2[i];

                if (list.contains(String.valueOf(chars1))) {
                  //  System.out.println(true);
                    n++;
                }

            }
        }
        System.out.println(n + 1);
    }


}
