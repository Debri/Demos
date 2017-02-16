package sort;

/**
 * Created by Liuqi
 * Date: 2017/2/16.
 */

/**
 * 二分排序
 * 在插入第i个元素时，对前面的0～i-1元素进行折半，先跟他们
 * 中间的那个元素比，如果小，则对前半再进行折半，否则对后半
 * 进行折半，直到left>right，然后再把第i个元素前1位与目标位置之间
 * 的所有元素后移，再把第i个元素放在目标位置上。
 */
public class DichotomySort {
    public static void doSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            int end = i - 1;
            int mid = 0;   //开始结束，中间的位置
            int temp = arr[i];   //第i位置的元素的值的大小
            while (start <= end) {
                mid = (start + end) / 2;
                if (temp < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            for (int j = i - 1; j > end; j--) {
                arr[j + 1] = arr[j];
            }
            arr[end + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int [] arr={1,43,65,6,43,7,-4,4,7,0,-34,-65};
        doSort(arr);
        DataUtil.doPrint(arr);
    }
}
