package off;

import org.junit.Test;

/**
 * Created by Liuqi
 * Date: 2017/4/16.
 */
public class SolutionTest {
    @Test
    public void testFind() throws Exception {
        Solution solution = new Solution();
        int[][] arr = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 7;
        System.out.println(  solution.Find(target, arr));
    }

}