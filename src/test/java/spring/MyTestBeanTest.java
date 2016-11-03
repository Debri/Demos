package spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

/**
 * Created by Liuqi
 * Date: 2016/11/2.
 */
public class MyTestBeanTest {

    @Test
    public void testSimpleLoad() {
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        MyTestBean myTestBean = (MyTestBean) factory.getBean("myBean");
        System.out.println(myTestBean.getName());
        InputStream stream = null;
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\test.xml");
            stream = resource.getInputStream();
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = stream.read(bytes)) != -1) {
                System.out.print(i);
                outputStream.write(bytes, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}