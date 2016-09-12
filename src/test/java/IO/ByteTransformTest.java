package IO;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/12
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ByteTransformTest {
    @Test
    public void fileToByte() throws Exception {
        byte data []=null;
       String path="D:"+ File.separator+"test.txt";
   /*    Class<?> cls = Class.forName("IO.ByteTransform");
        Object obj=cls.newInstance();
        Method method=cls.getMethod("FileToByte",String.class);
        data=method.invoke(obj,path);
        String str = method.invoke(obj,path).getClass().getSimpleName();
        System.out.println(str);*/
        ByteTransform bt=new ByteTransform();
        data=  bt.FileToByte(path);






    }

}