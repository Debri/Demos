package DataStructures;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.lang.Comparable;


/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class SelectionTest {
    Selection selection=new Selection();
    int x;
    @Test
    public void bubbleSort() throws Exception {

        int [ ] data=new int[] {1,2,3,2};
        int [] bu=selection.bubbleSort(data);

        for (int i=0;i<bu.length;i++,x=23){

            System.out.println(bu[i]);
        }
        System.out.println(x+"zhi");
    }

    @Test
    public void simpleMethod() throws Exception {
        int [ ] data=new int[] {1,2,3,2};
        int  bu = selection.simpleMethod(data,4);
        System.out.println(bu);
    }

}