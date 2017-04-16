package off;

/**
 * Created by Liuqi
 * Date: 2017/4/16.
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        boolean boo = false;
        int high = array.length;
        int width = array[0].length;
        if (target < array[0][0] && target > array[high - 1][width - 1]) {
            return false;
        }
        int i = high - 1;
        int j = width - 1;
        //先确定在哪一行
        if (array[i][j] > target && i >= 0 && j >= 0) {
            i--;
            j--;
        }


        if (array[i][j] == target || array[i + 1][j] == target || array[i + 1][j + 1] == target || array[i][j + 1] == target) {
            return true;
        }
        return false;
    }
}
