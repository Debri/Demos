package udp;

import org.junit.Test;

import java.net.InetAddress;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/10/4
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MulticastSnifferTest {
    @Test
    public void excute() throws Exception {
        InetAddress addr = InetAddress.getByName("239.255.255.250");
        MulticastSniffer ms = new MulticastSniffer();
        ms.excute(addr, 1900);
    }

}