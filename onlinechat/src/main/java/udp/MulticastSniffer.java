package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by Liuqi
 * Date: 2016/10/4
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 组播
 */
public class MulticastSniffer {
    public void excute(InetAddress group, int port) {
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);
            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.setSoTimeout(10000);
                ms.receive(dp);
                String str = new String(dp.getData(), "8859_1");
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
