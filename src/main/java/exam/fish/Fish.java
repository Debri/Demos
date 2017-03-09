package exam.fish;

import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/9.
 */
public class Fish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = new String[3];


        for (int i = 0; i < 3; i++) {
            str[i] = scanner.next();
           /* System.out.println(str[i]);*/
        }
        int minSize;
        int maxSize;
        int num;
        int[] currentSize;

    }

    public static int printNum(int min, int max, int num, int[] currentSize) {
        int realMin = 0;
        int realMax = 0;
        for (int i = 0; i < num; i++) {
            realMin = realMin >= 2 * currentSize[i] ? 2 * currentSize[i] : realMin;
            realMax = realMax >= 5 * currentSize[i] ? realMax : 5 * currentSize[i];
        }
        int size = (realMin - min) > 0 ? (realMin - min) : 0 + (realMax - max) > 0 ? realMax - max : 0;
        System.out.println(size);
        return size;
    }
}
