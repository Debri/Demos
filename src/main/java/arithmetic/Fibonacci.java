package arithmetic;

/**
 * Created by Liuqi
 * Date: 2017/2/14.
 */

import java.util.Scanner;

/**
 * 递归计算斐波那契额函数第n项的值
 */
public class Fibonacci {
    public static long k = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        System.out.println(doJisuan(a));
        System.out.println("调用了" + k + "次");
    }

    public static long doJisuan(long m) {
        if (m == 0 || m == 1) {
            k++;
            return m;
        } else {
            return doJisuan(m - 1) + doJisuan(m - 2);
        }
    }
}
