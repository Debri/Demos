package DataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class SelectionTest {
    Selection selection=new Selection();
    @Test
    public void bubbleSort() throws Exception {
        int [ ] data=new int[] {1,2,3,2};
        int [] bu=selection.bubbleSort(data);
        for (int i=0;i<bu.length;i++){
            System.out.println(bu[i]);
        }

    }

    @Test
    public void simpleMethod() throws Exception {
        int [ ] data=new int[] {1,2,3,2};
        int  bu = selection.simpleMethod(data,4);
        System.out.println(bu);
    }

}