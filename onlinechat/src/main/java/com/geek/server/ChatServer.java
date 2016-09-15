package com.geek.server;

import com.geek.Bean.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ChatServer {
    List<SingleConnection> list=new ArrayList<SingleConnection>();
    public static void main(String[] args) {
        new ChatServer().start();
    }

    public void start() {
        boolean startd = false;
        ServerSocket serverSocket = null;
        Socket s = null;
        DataInputStream dis = null;
        try {
            serverSocket = new ServerSocket(8888);
            startd = true;
        } catch (IOException e) {
            System.out.println("server started error");
            e.printStackTrace();

        }
        try {
            while (startd) {
                s = serverSocket.accept();
                System.out.println("成功链接到服务器");
                SingleConnection sc = new SingleConnection(s);
                new Thread(sc).start();
                list.add(sc);
            }
        } catch (IOException e) {

            e.printStackTrace();
            System.out.println("client closed！");
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
