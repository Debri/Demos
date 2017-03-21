package DataStructures.search;

/**
 * Created by Liuqi
 * Date: 2017/3/20.
 */
public class BinarySearch {

    public boolean Find(int target, int[][] array) {
        int high = array.length;
        int width = array[0].length;
        if (target > array[0][0] && target < array[high - 1][width - 1]) {
            for (int i = 0; i < high; i++) {
                if (array[i][width - 1] > target) {
                    if (judgeExist(target, array[i], 0, width)>0)
                        return true;
                }
            }
        }
        return false;
    }

   /* static boolean judgExist(int target, int[] arr, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] < target)
            judgExist(target, arr, mid + 1, end);
        if (arr[mid] > target)
            judgExist(target, arr, start, mid - 1);
        if (arr[mid] == target)
            return true;
        return false;
    }*/
   int judgeExist(int khey, int arr[], int start, int end ) {
       int mid;
       while (start <= end) {
           mid = start + (end - start) / 2; //直接平均可能會溢位，所以用此算法
           if (arr[mid] < khey)
               start = mid + 1;
           else if (arr[mid] > khey)
               end = mid - 1;
           else
               return mid; //最後檢測相等是因為多數搜尋狀況不是大於要不就小於
       }
       return -1;
   }
}
