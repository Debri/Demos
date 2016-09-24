package internet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/24
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class InetTest {
    Inet inet = new Inet();

    @Test
    public void getMyAddr() throws Exception {
        System.out.println(inet.getMyAddr());
    }

}