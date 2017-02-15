package sort;

/**
 * Created by Liuqi
 * Date: 2017/2/15.
 */

/**
 * 选择排序
 * 每次遍历选择出最小的元素放在首部
 */
public class SelectionSort {
    public static void doSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[i]>source[j]){
                    int temp=source[i];
                    source[i]=source[j];
                    source[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] source={1,23,4,5,2,5,3,-1,-4,0};
        doSort(source);
        System.out.println(source);
        for (int i=0;i<source.length;i++){
            System.out.println(source[i]);
        }
    }
}
