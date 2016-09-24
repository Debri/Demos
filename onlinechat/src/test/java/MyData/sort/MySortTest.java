package MyData.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/21
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MySortTest {
    MySort ms = new MySort();
    int[] a;
    Integer[] data;

    @Before
    public void setup() {
        data = new Integer[]{5, 4, 3, 2, 1};
        a = new int[]{87, 2, 6, 4, 8, 9, 45, 45, 7, 3, 2, 23, 4, 6};
    }

    @Test
    public void insertionSort() throws Exception {
        List<Integer> list = Arrays.asList(data);
        Collections.sort(list);
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        /*for (Integer i:list){
            System.out.println(i);
        }*/
        ms.insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
        }
    }

    @Test
    public void shellSort() throws Exception {
        ms.shellSort(a);
        String str = "1231";
        str = "3456";
        System.out.println(str);
        for (int i = 0; i < a.length; i++) {
            System.out.println("希尔" + a[i]);
        }
    }

    @Test
    public void heapSort() throws Exception {
        ms.heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("堆" + a[i]);
        }
    }

    @Test
    public void mergeSort() {
        MySort.margeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println("归并" + a[i]);
        }
    }

    @Test
    public void testQuickSort() {
        //ms.quickSort(data,0,data.length-1);
        for (int i = 0; i < data.length; i++) {
            System.out.println("kuaisu" + data[i]);
        }
    }


}