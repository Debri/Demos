package concurrent.test2;

/**
 * Created by Liuqi
 * Date: 2017/4/5.
 */
public class sort {
    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int middle = partation(data, low, high);
            quickSort(data, low, middle - 1);
            quickSort(data, middle + 1, high);

        }

    }

    public static int partation(int[] data, int low, int high) {
        int temp = data[low];
        while (low < high) {
            while (low < high && temp > data[high]) {
                high--;
            }
            data[low] = data[high];
            while (low < high && temp < data[low]) {
                low++;
            }
            data[high] = data[low];
        }
        data[low] = temp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }
}
