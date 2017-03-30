package exam;

import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/27.
 */
public class Main4 {
    public static int doCount(int n, int[] arr) {
        int thread1 = arr[0];
        int thread2 = arr[1];
        for (int i = 2; i < n; i++) {
            if (thread1 + thread2 < arr[i]) {
                thread1 += thread2;
                thread2 = arr[i];
                continue;
            }
            if (thread1 < thread2) {
                thread1 += arr[i];
            } else {
                thread2 += arr[i];
            }
        }
        return Math.max(thread1, thread2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            arr[i] = scanner.nextInt();
            //System.out.println(arr[i++]);
            i++;
        }
        System.out.println(doCount(n, arr));
    }
}
