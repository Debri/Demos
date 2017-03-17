package MyNio.IO;


import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by Liuqi
 * Date: 2017/3/12.
 */
public class IOServer {


    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(2345));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
