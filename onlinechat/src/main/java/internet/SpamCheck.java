package internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Liuqi
 * Date: 2016/9/25
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    /**
     * 检查一个网址是否是一个垃圾邮件地址
     *
     * @param arg
     * @return
     */
    public boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] bytes = address.getAddress();
            String query = BLACKHOLE;
            for (byte b : bytes) {
                int unsignedByte = b < 0 ? b + 256 : b;
                query = unsignedByte + "." + query;
            }
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        }

    }
}
