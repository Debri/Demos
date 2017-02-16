package sort;

/**
 * Created by Liuqi
 * Date: 2017/2/15.
 */

/**
 * 希尔排序
 * 是插入排序的一种。 将数据进行分组，对每一组进行排序，在每一组有序以后就可以对所有的分组利用插入排序进行最后依次排序
 */
public class ShellSort {
    /* public static void doSort(int[] source) {
         int len = source.length;
         int i, j, gap;
         for (gap = len / 2; gap >=1; gap /= 2) {
             for (i = gap; i < len; i++) {
                 for (j = i ; j >=gap; j -= gap) {
                     if (source[j - gap] > source[j]) {
                         DataUtil.doSwap(source, j, j - gap);
                     }
                 }
             }
         }
     }*/
    public static void doSort(int[] arr) {
        int temp;
        for (int delta = arr.length / 2; delta >= 1; delta /= 2) {                 //对每个增量进行一次排序
            for (int i = delta; i < arr.length; i++) {
                for (int j = i; j >= delta; j -= delta) {                          //注意每个地方增量和差值都是delta
                    if (arr[j] < arr[j - delta]) {
                        DataUtil.doSwap(arr, j, j - delta);
                    }
                    /*temp = arr[j - delta];
                    arr[j - delta] = arr[j];
                    arr[j] = temp;*/
                }
            }
        }
    }

    //尚未完成！！！！！
    public static void main(String[] args) {
        int[] arr = {12, 32, 34, 56, 7, -4, -54, 4, 7, 43, 5, 6, 7, 86, 4, -2, 23};
        doSort(arr);
        DataUtil.doPrint(arr);
    }
}
