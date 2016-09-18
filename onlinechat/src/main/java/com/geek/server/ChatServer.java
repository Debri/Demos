package com.geek.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ChatServer {
    List<SingleConnection> list = new ArrayList<SingleConnection>();

    public static void main(String[] args) {
        UUID i= UUID.randomUUID();
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
                list.add(sc);
                new Thread(sc).start();
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

    public class SingleConnection implements Runnable {

        private Socket socket;
        private DataInputStream dis = null;
        private DataOutputStream dos = null;
        private boolean bConnected = false;

        public SingleConnection(Socket socket) {
            this.socket = socket;
            try {
                bConnected = true;
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void send(String str)  {

            try {
                dos.writeUTF(str);
            } catch (IOException e) {
                list.remove(this);
                System.out.println("有客户端退出了");
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                while (bConnected) {
                    String str = dis.readUTF();
                    System.out.println(str);
                    for (int j = 0; j < list.size(); j++) {
                        SingleConnection singleConnection = list.get(j);
                        singleConnection.send(str);
                    }
                    //不使用这种循环方法，1，会对这个List进行锁定
                    //2.效率低
                    /*
                     Iterator<SingleConnection> iterator=list.iterator();
                     while (iterator.hasNext()){
                        SingleConnection singleConnection=iterator.next();
                        singleConnection.send(str);

                    }*/
                }

            } catch (EOFException e) {
                e.printStackTrace();
            } catch (SocketException e) {/*
                if (singleConnection != null) {
                    list.remove(singleConnection);
                }*/
                //list.remove(this);
                //System.out.println("有客户退出了");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dis != null) {
                        dis.close();
                        dis = null;
                    }
                    if (dos != null) {
                        dos.close();
                        dos = null;
                    }
                    if (socket != null) {
                        socket.close();
                        socket = null;
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
