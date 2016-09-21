package MyData.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/21
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class BinaryHeapTest {
    private Element min;
    private BinaryHeap bh;
    private Element[] elements;

    @Before
    public void setup() {
        bh = new BinaryHeap(10);
        for (int i = 0; i < 10; i++) {
            bh.insert(new Element(i + 1));
        }
        min = (Element) bh.findMin();
        System.out.println(min.getI());

    }

    @Test
    public void makeEmpty() throws Exception {
        bh.makeEmpty();
        assertTrue(bh.getCurrentSize() == 0);
    }

    @Test
    public void insert() throws Exception {
        min = new Element(90);
        bh.insert(min);
    }

    @Test
    public void findMin() throws Exception {

    }

    @Test
    public void deleteMin() throws Exception {
        bh.deleteMin();
        assertTrue(((Element) bh.findMin()).getI() == 2);
    }

    @Test
    public void buildHeap() throws Exception {
        bh.buildHeap();
        elements = (Element[]) bh.getArrays();
        for (int i = 0; i < bh.getCurrentSize(); i++) {
            System.out.println(elements[1].getI());
        }

    }

}