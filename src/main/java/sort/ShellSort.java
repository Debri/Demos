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
    public static void doSort(int[] source) {
        int len = source.length;
        int i, j, gap;
        for (gap = len / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < len; j += gap) {
                    if (source[j - gap] > source[j]) {
                        DataUtil.doSwap(source, j, j - gap);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] arr={12,32,34,56,7,-4,-54,4,7,43,5,6,7,86,4,-2,23};
        doSort(arr);
        DataUtil.doPrint(arr);
    }
}
