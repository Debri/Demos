package MyNio;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by Liuqi
 * Date: 2016/10/3
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ChargenClient {
    public static final Logger logger = Logger.getLogger(ChargenClient.class);
    public static final int DEFAULT_PORT = 19;

    /**
     * 一个基于通道的客户端
     */
    public void excuteClient(String add) {
        SocketAddress socketAddress = new InetSocketAddress(add, DEFAULT_PORT);
        try {
            SocketChannel client = SocketChannel.open(socketAddress);
            //文本行有74个ASCII字符长，后面是两位是回车/换行对
            ByteBuffer buffer = ByteBuffer.allocate(74);
            WritableByteChannel out = Channels.newChannel(System.out);
            while (client.read(buffer) != -1) {
                //回绕到缓冲区
                buffer.flip();
                out.write(buffer);
                //使用的是同一个缓冲区，每读一次清空
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
