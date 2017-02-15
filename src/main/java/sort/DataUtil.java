package sort;

/**
 * Created by Liuqi
 * Date: 2017/2/15.
 */
public class DataUtil {
    public static void doSwap(int[] source, int x, int y) {
        int temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }

    public static void doPrint(int[] source) {
        for (int i = 0; i < source.length; i++) {
            System.out.print(source[i]+" ");

        }
        System.out.println();
    }

}
