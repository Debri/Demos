package mythread.threadpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Liuqi
 * Date: 2016/10/10
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    /**
     * 初始化线程池
     */
    public ConnectionPool(int initsize) {
        if (initsize > 0) {
            for (int i = 0; i < initsize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 释放一条连接给线程池
     *
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 指定mills时间内获得连接
     *
     * @param mills
     * @return
     * @throws InterruptedException
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
