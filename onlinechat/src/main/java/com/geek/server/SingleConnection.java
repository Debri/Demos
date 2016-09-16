/*
package com.geek.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
*/
/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 *//*

public class SingleConnection implements Runnable {

    private Socket socket;
    private DataInputStream dis = null;
    private DataOutputStream dos=null;
    private boolean bConnected=false;

    public SingleConnection(Socket socket) {
        this.socket = socket;
        try {
            bConnected = true;
            dis = new DataInputStream(socket.getInputStream());
            dos=new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String str){
        try {
            dos.writeUTF(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (bConnected) {
                String str = dis.readUTF();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
               if (dis!=null) dis.close();
                if (dos!=null)  dos.close();
                if (socket!=null)  socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
*/
