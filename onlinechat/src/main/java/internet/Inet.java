package internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Liuqi
 * Date: 2016/9/24
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Inet {
    public static void main(String[] args) {
        byte[] b = new byte[]{(byte) 172, 22, 4, 2};
        InetAddress[] addresses = null;
        try {
            addresses = InetAddress.getAllByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        for (InetAddress address : addresses) {
            System.out.println(address.getAddress());
            System.out.println(address);
            System.out.println(address.getHostAddress());
            System.out.println(address.getHostName());
        }

    }

    public String getMyAddr() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return address.toString();
    }
}
