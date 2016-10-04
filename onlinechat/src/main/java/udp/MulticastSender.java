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
 * 将数据发送给一个组播
 */
public class MulticastSender {
    public void excute(InetAddress addr, int port) {
        byte ttl = (byte) 1;
        byte[] data = "here we go\r\n".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, addr, port);
        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket();
            ms.setTimeToLive(ttl);
            ms.joinGroup(addr);
            for (int i = 1; i < 10; i++) {
                ms.send(dp);
            }
            ms.leaveGroup(addr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ms != null) {
                ms.close();
            }
        }
    }
}
