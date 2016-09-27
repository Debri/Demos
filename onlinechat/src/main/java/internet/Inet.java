package internet;

import java.io.*;
import java.net.*;

/**
 * Created by Liuqi
 * Date: 2016/9/24
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Inet {
    /**
     * 使用URLConnection下载一个web页面
     * 并且将其写到磁盘文件中
     */
    public void sourceView2(String u, String path) {

        try {
            URL url = new URL(u);

            String filename = url.getFile();//获取URL中包含的二进制文件的名字
            filename = filename.substring(filename.lastIndexOf("/") + 1);

            URLConnection uc = url.openConnection();

            int contentLenth = uc.getContentLength();
            String contentType = uc.getContentType();

            try (InputStream raw = uc.getInputStream()) {//java 7的写法，同时当输入流结束的时候可以自动关闭
                InputStream is = new BufferedInputStream(raw);
                Reader reader = new InputStreamReader(is);
                int c = 0;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

    /**
     * 使用简单的openStream下载一个web页面
     */
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
