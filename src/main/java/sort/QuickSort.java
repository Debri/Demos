package sort;

/**
 * Created by Liuqi
 * Date: 2017/2/15.
 */

/**
 * 快速排序
 * 分治法，想选去一个任意元素作为基准，将当前无序区划分为左右两个子区间
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {1,2,4,1,3,2,324,5123,-23,45,-3,0};
        doSort(arr);
        DataUtil.doPrint(arr);
    }
    public static void doSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursive(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = arr[end];
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right) {
                left++;
            }
            while (arr[right] >= mid && left < right) {
                right--;
            }
            DataUtil.doSwap(arr, left, right);
        }
        if (arr[left] >= arr[end]) {
            DataUtil.doSwap(arr, left, end);
        } else {
            left++;
        }
        quickSortRecursive(arr, start, left - 1);
        quickSortRecursive(arr, left + 1, end);
    }


}
