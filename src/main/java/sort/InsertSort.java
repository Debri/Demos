package sort;

/**
 * Created by Liuqi
 * Date: 2017/2/15.
 */

/**
 * 插入排序
 * 葱第一个元素开始可以认为已经有序，取出下一元素在已经有序的序列从后向前扫面 ，交换
 */
public class InsertSort {
    public static void doSort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            //从后向前依次扫描、交换
            for (int j = i; j > 0 && source[j] < source[j-1]; j--) {
                int temp = source[j-1];
                source[j-1] = source[j];
                source[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int [] source={12,234,54,56,3,56,6,4,-3,5,0,45};
        doSort(source);

        DataUtil.doPrint(source);
    }
}
