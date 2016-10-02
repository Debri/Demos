package mySocket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

/**
 * Created by Liuqi
 * Date: 2016/9/27
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyClient {
    public MyClient() throws IOException {
    }

    /**
     * 从time.nist.gov服务器获取时间
     */
    public StringBuilder receiveTime() {
        Socket socket = null;
        StringBuilder time = new StringBuilder();
        try {
            socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            InputStream is = socket.getInputStream();
            Reader reader = new InputStreamReader(is, "ASCII");
            int i;
            while ((i = reader.read()) != -1) {
                time.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return time;
    }

    /**
     * 加密的Socket
     */
    public void sslSocket(String host, int port) {
        //使用SSLSocketFactory.getDefault()获取加密的Socket
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        SSLSocket socket = null;
        try {
            //createSocket()方法
            socket = (SSLSocket) socketFactory.createSocket(host, port);
            String[] str = socket.getSupportedCipherSuites();
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
            }
            Writer writer = new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream()));
            writer.write("bingo");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
