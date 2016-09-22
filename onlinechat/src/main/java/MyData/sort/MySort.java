package MyData.sort;

/**
 * Created by Liuqi
 * Date: 2016/9/21
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MySort {
    /**
     * 插入排序
     * 在第j趟排序中;将位置在j上的元素向左移动在他的前j+1元素的正确的位置上
     */
    public void insertionSort(int[] data) {
        int i = 0;
        for (int j = 0; j < data.length; j++) {
            int temp = data[j];
            for (i = j; i > 0 && temp < data[i - 1]; i--) {
                data[i] = data[i - 1];
            }
            data[i] = temp;
        }
    }

    /**
     * 希尔排序 （不稳定）
     * 如果你想要结果从小到大排列，它会首先将数组进行分组，然后将较小值移到前面，较大值
     * 移到后面，最后将整个数组进行插入排序，这样比起一开始就用插入排序减少了数据交换和移动的次数
     * 可以说希尔排序是加强版的插入排序
     */
    public void shellSort(int[] data) {
        for (int gap = data.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < data.length; i++) {
                int temp = data[i];
                int j = i;
                for (; gap <= j && temp < data[j - gap]; j = j - gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
    }

    /**
     * 堆排序 稳定的排序
     */
    public void heapSort(int[] data) {
        for (int i = data.length / 2; i >= 0; i--) {
            percDown(data, i, data.length);
        }
        for (int i = data.length - 1; i > 0; i--) {
            swapReference(data, 0, i);
            percDown(data, 0, i);
        }
    }

    //数据交换
    private static void swapReference(int[] data, int i, int n) {
        int temp = data[i];
        data[i] = data[n];
        data[n] = temp;
    }

    //下坠操作，创建大顶堆
    private static void percDown(int[] data, int i, int n) {
        int child;
        int temp;
        for (temp = data[i]; leftChild(i) < n; i = child) {/**/
            child = leftChild(i);
            if (child != n - 1 && data[child] < data[child + 1]) {
                child++;
            }
            if (temp < data[child]) {
                data[i] = data[child];
            } else
                break;
        }
        data[i] = temp;
    }

    private static int leftChild(int i) {
        return 2 * i;
    }

}
