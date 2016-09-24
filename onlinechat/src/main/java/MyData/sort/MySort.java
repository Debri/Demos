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

    /**
     * 归并排序
     */
/*
    public void mergeSort(int[] data) {

        //int[] tempArray = new int[data.length];
       // margeSort(data, tempArray, 0, data.length - 1);
    }

    private static void margeSort(int[] data, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            margeSort(data, tempArray, left, center);
            margeSort(data, tempArray, center + 1, right);
            marge(data, tempArray, left, center + 1, right);
        }
    }

    //归并过程
    private static void marge(int[] data, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (data[leftPos] <= data[rightPos]) {
                tempArray[tempPos++] = data[leftPos++];
            } else {
                tempArray[tempPos++] = data[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tempArray[tempPos++] = data[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tempArray[tempPos++] = data[rightPos++];
        }
        for (int i = 0; i < numElements; i++) {
            data[rightEnd] = tempArray[rightEnd];
        }
    }*/
    public static int[] margeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            margeSort(nums, low, mid);
            // 右边
            margeSort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

    /**
     * 快速排序
     * 时间复杂度 平均O(NlogN) 最坏O(N^2)
     */
    public void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            quickSort(list, low, middle - 1);        //对低字表进行递归排序
            quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }
}
