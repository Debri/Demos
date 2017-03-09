package MyData.arr;

/**
 * Created by Liuqi
 * Date: 2017/3/9.
 */

/**
 * 输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值，要求时间复杂度为O(n)。
 * 例如输入的数组为  1, -2, 3, 10, -4, 7, 2, -5  ，和最大的子数组为  3, 10, -4, 7, 2  ， 因此输出为该子数组的和18。
 */
public class MaxChildArrSum {
    public static void main(String[] args) {
        int[] arr = {2, 34, -5, -6, 34 - 32, 5};
        MaxChildArrSum.printMax(arr);

    }

    public static int printMax(int[] arr) {
        int currMax = 0;//currSum为当前最大子数组的和
        int maxSum = arr[0];//最后要返回的最大子数组的和
        for (int i = 0; i < arr.length; i++) {
            currMax = (currMax >= currMax + arr[i]) ? currMax : currMax + arr[i];
            maxSum = maxSum > currMax ? maxSum : currMax;
        }
        System.out.println(maxSum);
        return maxSum;
    }
}
