package internet;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
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

    public void viewSourceByte(String u) {
        InputStream is = null;
        try {
            URL url = new URL(u);
            is = url.openStream();
            int str;
            while ((str = is.read()) != -1) {
                System.out.print((char) str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 和上面方法比较使用了缓冲区和Reader  提高了性能 并且不回导致乱码
     */
    public void viewSource(String str) {
        InputStream is = null;
        try {
            URL url = new URL(str);
            Object obj = url.getContent();
            System.out.println(obj.getClass().getName());
            is = url.openStream();
            //使用缓冲区以提高性能
            is = new BufferedInputStream(is);
            Reader reader = new InputStreamReader(is);
            int i = 0;
            while ((i = reader.read()) != -1) {
                //System.out.print((char) i);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                }
            }
        }

    }
}
