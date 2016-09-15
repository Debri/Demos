package com.geek.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class CharClient extends JFrame {
    Socket socket=null;
    DataOutputStream dos=null;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class TFListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str = textField.getText().trim();
            textArea.setText(str);
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
     * @throws Exception
     */
    public void connect() throws Exception {
        socket = new Socket("127.0.0.1", 8888);
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("成功链接");
    }

    /**
     * 关闭连接
     */
    public void disConnect(){
        try {
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
