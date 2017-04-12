package exam;

import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/4/11.
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        doPrint(n);
    }

    public static void doPrint(int n) {
        int[] a = new int[50];
        int sum = 0;
        int l = 0;
        int left = 0;
        for (int i = 2; i <= n; i++) {
            a[l++] = i;
            sum += i;
            if (sum > n) {
                sum -= i;
                l--;
                left = n - sum;
                break;
            }
        }
        for (int i = l - 1; left > 0; left--) {
            a[i]++;
            i--;
            if (i < 0) {
                i = l - 1;
            }
        }
        for (int i=0;i<l-1;i++){
            System.out.print(a[i]+"    --");
            System.out.println(a[l-1]);
        }
    }
}
