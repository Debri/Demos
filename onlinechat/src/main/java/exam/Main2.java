package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/4/11.
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        doPrint(n);

    }

    /**
     * 由题意可知分越多的3越大，不足的的部分分为2，假如最后剩余4，分为2+2
     *
     * @param n
     */
    public static void doPrint(int n) {
        int sum = 1;
        int x = 0;//分为3的数量
        int m = 2;
        List<Integer> list = new ArrayList<>();
        n=n-2;
        for (; n > m; n = n - m) {
            list.add(m);
            m++;
            if (n-m<=m){
                break;
            }
        }
               sum *= n;
        for (Integer s : list) {
            sum *= s;
        }
        System.out.println(sum);
    }
}
