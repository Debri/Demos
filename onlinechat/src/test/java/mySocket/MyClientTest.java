package mySocket;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/27
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyClientTest {
    MyClient mc = new MyClient();

    public MyClientTest() throws IOException {
    }

    @Test
    public void testReceiveTime() {
        System.out.println(mc.receiveTime());
    }

}