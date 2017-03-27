package exam;

import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/25.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];
       /* String input = scanner.next();
        String[] str = input.split(" ");
        System.out.println(str.length);
        System.out.println(input+"==========");

        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
            System.out.println(str[i]+"---------------");
        }*/
        int i = 0;
        while (i != 4) {
            arr[i] = Integer.parseInt(scanner.next());
            System.out.println(arr[i] + "-------");
            i++;
        }
        int start = arr[0] > arr[2] ? arr[2] : arr[0];
        int end = arr[1] > arr[3] ? arr[1] : arr[3];
        System.out.println(end - start + 1);
    }
}
