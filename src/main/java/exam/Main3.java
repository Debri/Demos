package exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/25.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        int i = 0;
        while (i < n) {
            input[i++] = Integer.parseInt(scanner.next());
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int j = n - 1; j >= 0; j--) {
            set.add(input[j]);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer value : set) {
            //System.out.print(value + " ");
            sb.append(value + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
