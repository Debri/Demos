package exam;

import org.junit.Test;

import java.io.File;

/**
 * Created by Liuqi
 * Date: 2017/3/9.
 */
public class ProgramTestTest {
    @Test
    public void testTest1() throws Exception {
        long start = System.currentTimeMillis();
        File file = new File("C:\\Users\\Admin\\Desktop\\javatest\\data\\input.data");
        File output = new File("C:\\Users\\Admin\\Desktop\\javatest\\data\\output.data");
        //  System.out.println(output.exists());
        ProgramTest.test(file, output, null);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}