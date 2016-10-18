package DataStructures;

/**
 * Created by Liuqi
 * Date: 2016/9/14
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Selection {
    /**
     * 冒泡排序算法
     */
    public static int [] bubbleSort(int [] arr){
        int arrlen=arr.length;
        //int [] bubble = new int[arrlen];
        int temp=0;
        for (int i=0;i<arrlen;i++){
            for(int j=i+1;j<arrlen;j++){
                if (arr[i]<arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    /**
     *从数组中确定前k个最大数
     */
    public int simpleMethod( int [] data,int k){
        int[] karr = new int[k];
        System.arraycopy(data,0,karr,0,k);

        bubbleSort(karr);

        for (int i=k;i<data.length;i++){
            for (int j=0;j<k;j++){
                if (data[i] > karr[j]){
                    karr[j]=data[i];
                }
            }
        }
    return karr[k-1];

    }

    /**
     * 桶式排序
     * @param a
     * @param max 数组a中最大值
     */
    public void bucketSort(int[] a,int max){

        //注意了，这里 max > a[i],即 max 大于a中最大值
        int[] buckets=new int[max];
        for(int i=0;i<a.length;i++){
            int x=a[i];
            buckets[x]++;
        }
        // 计算“落入”各桶内的元素在有序序列中的位置
        for (int i = 1; i < max; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }

        // 将a的元素完全复制到tmp数组中

        int tmp[] = Arrays.copyOf(a, a.length);
        // 根据buckets数组中的位置信息将待排序列的各元素放入相应位置
        for (int k = a.length - 1; k >= 0; k--) {
            a[--buckets[tmp[k]]] = tmp[k];
        }
    }
    public void simple(){}


}
