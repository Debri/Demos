package DataStructures.search;

import org.junit.Test;

/**
 * Created by Liuqi
 * Date: 2017/3/20.
 */
public class BinarySearchTest {
    @Test
    public void testFind() throws Exception {
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        BinarySearch search = new BinarySearch();
        System.out.println(search.Find(7, arr));
    }
}