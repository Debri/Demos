package MyData.sort;

import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setup() {
        a = new int[]{2, 4, 8, 9, 45, 45, 7, 3, 6};
    }

    @Test
    public void insertionSort() throws Exception {
        ms.insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            //System.out.println(a[i]);
        }
    }

    @Test
    public void shellSort() throws Exception {
        ms.shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("希尔" + a[i]);
        }
    }


}