package exam1;

/**
 * Created by Liuqi
 * Date: 2017/3/6.
 */
public class Arr1 {
    public static int printMax(int n, int[] arr) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                temp += arr[i];
            } else if (temp > max) {
                max = temp;
                temp = 0;
            }
        }
        return max;
    }

}
