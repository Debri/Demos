package IO;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ListFileTest {
    @Test
    public void readFile() throws Exception {
        String path = "C:" + File.separator + "Users" + File.separator + "Admin" + File.separator + "Desktop" + File.separator + "三下乡报告_刘奇.docx";
        Class<?> cls = Class.forName("IO.ListFile");
        Object obj=cls.newInstance();
        Method [] methods=cls.getClass().getDeclaredMethods();
        for (int i=0;i<methods.length;i++){
            System.out.println(methods[i].getName());

        }
        Method met=cls.getDeclaredMethod("readFile",String.class);

        met.invoke(obj,path);

    }

}