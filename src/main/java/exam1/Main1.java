package exam1;

import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/4/1.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            doJisuan(str.toCharArray());
        }
    }

    public static void doJisuan(char[] arr) {
        if (arr == null) {
            return;
        }
        int result = 0;
        int n = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 'a' && arr[i] > 'z') {
                return;
            }
            int x = arr[i] - 'a';
            result += n * x;
            n = n * 26;
        }
        System.out.println(result);
    }
}
