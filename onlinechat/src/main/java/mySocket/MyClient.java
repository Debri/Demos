package mySocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

/**
 * Created by Liuqi
 * Date: 2016/9/27
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyClient {
    /**
     * 从time.nist.gov服务器获取时间
     *
     * @return
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


    public MyClient() throws IOException {
    }
}
