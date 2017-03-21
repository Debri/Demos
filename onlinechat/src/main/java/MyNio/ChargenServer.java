package MyNio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Liuqi
 * Date: 2016/10/3
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 用Chargen在一个线程中处理多个连接
 */
public class ChargenServer {

    private static final int DEFAULT_PORT = 19;

    public void excute() {
        byte[] ratation = new byte[95 * 2];
        for (byte b = ' '; b < '~'; b++) {
            ratation[b - ' '] = b;
            ratation[b - 95] = b;
        }
        ServerSocketChannel channel = null;
        Selector selector = null;
        try {
            //调用静态工厂方法
            channel = ServerSocketChannel.open();
            ServerSocket serverSocket = channel.socket();
            InetSocketAddress address = new InetSocketAddress(DEFAULT_PORT);
            serverSocket.bind(address);
            channel.configureBlocking(false);
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> ite = readyKeys.iterator();
            while (ite.hasNext()) {
                SelectionKey key = ite.next();
                ite.remove();
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from " + client);
                        client.configureBlocking(false);
                        SelectionKey key1 = client.register(selector, SelectionKey.OP_WRITE);
                        //创建缓冲区，基于数组实现的
                        ByteBuffer buffer = ByteBuffer.allocate(74);
                        buffer.put(ratation, 0, 72);
                        buffer.put((byte) '\r');
                        buffer.put((byte) '\n');
                        //将缓冲区位置回绕到0
                        buffer.flip();
                        key1.attach(buffer);
                    } else if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        if (!buffer.hasRemaining()) {
                            buffer.rewind();
                            int first = buffer.get();
                            buffer.rewind();
                            int position = first - ' ' + 1;
                            buffer.put(ratation, position, 72);
                            buffer.put((byte) '\r');
                            buffer.put((byte) '\n');
                            buffer.flip();

                        }
                        client.write(buffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
