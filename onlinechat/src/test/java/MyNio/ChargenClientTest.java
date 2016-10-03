package MyNio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/10/3
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ChargenClientTest {


    @Test
    public void excuteClient() throws Exception {
        ChargenClient client = new ChargenClient();
        client.excuteClient("rama.poly.edu");
    }

    @Test
    public void test() throws Exception {
        for (byte b = ' '; b < '~'; b++) {
            System.out.println((char) b);
        }

    }

}