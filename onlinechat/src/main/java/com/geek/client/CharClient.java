package com.geek.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 客户端
 */
public class CharClient extends JFrame {

    Socket socket = null;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    private boolean bConnected = false;
    TextField textField = new TextField();
    TextArea textArea = new TextArea();
    public static void main(String[] args) {
        new CharClient().launchFrame();

    }

    public void launchFrame() {
        this.setLocation(300, 400);
        this.setSize(400, 300);
        this.add(textField, BorderLayout.SOUTH);
        this.add(textArea, BorderLayout.NORTH);
        pack();
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                disConnect();
                System.exit(0);
            }
        });
        textField.addActionListener(new TFListener());
        this.setVisible(true);
        try {
            this.connect();
            new Thread(new RecThread()).start();
            bConnected = true;
        } catch (Exception e) {
            e.printStackTrace();
            this.disConnect();
            System.out.println("发生错误,或服务未开启");

        }
    }

    public class TFListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str = textField.getText().trim();
            //textArea.setText(str);
            textField.setText("");
            try {
                dos.writeUTF(str);
                dos.flush();
                //dos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 打开链接
     *
     * @throws Exception
     */
    public void connect() throws Exception {
        socket = new Socket("127.0.0.1", 8888);
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
        System.out.println("成功链接");
    }

    /**
     * 关闭连接
     */
    public void disConnect() {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class RecThread implements Runnable {
        public void run() {
            while (bConnected) {
                String str = null;
                try {
                    str = dis.readUTF();
                    //System.out.println(str);
                    textArea.setText(textArea.getText() + str + "\n");
                } catch (EOFException e) {
                    e.printStackTrace();
                    System.out.println("退出了！");
                } catch (SocketException e) {
                    disConnect();
                    System.out.println("服务器出现异常");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
