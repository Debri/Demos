package http;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Liuqi
 * Date: 2016/10/2
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyHTTP {
    private static Logger logger = Logger.getLogger("MyHTTP");
    private static final int THREAD_NUM = 50;
    private static final String INDEX_FILE = "index.html";
    private final File rootDirectory;
    private final int port;

    public MyHTTP(File rootDirectory, int port) throws IOException {

        if (!rootDirectory.isDirectory()) {
            throw new IOException(rootDirectory + "不存在");
        }
        this.rootDirectory = rootDirectory;
        this.port = port;
    }

    /**
     * 主方法
     *
     * @param filepath
     * @param port
     */
    public static void ececute(String filepath, int port) {
        File docroot = null;
        try {
            docroot = new File(filepath);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();

        }
        try {
            MyHTTP webServer = new MyHTTP(docroot, port);
            webServer.start();
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "Server could not start", e);
        }
    }

    public void start() {
        //创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port);
            logger.info("连接到服务器" + ss.getLocalPort());
            logger.info("文件路径" + rootDirectory);
            //循环以监听请求
            while (true) {
                try {
                    Socket request = ss.accept();
                    Runnable runnable = new RequestHandler(rootDirectory, INDEX_FILE, request);
                    pool.submit(runnable);
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Error accepting connection", e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
