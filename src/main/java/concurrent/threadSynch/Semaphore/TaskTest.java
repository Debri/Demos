package concurrent.threadSynch.Semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Liuqi
 * Date: 2017/2/23.
 */
public class TaskTest {
    public static void print(String str) {
        SimpleDateFormat dfdate = new SimpleDateFormat("HH:mm:ss");
        System.out.println("[" + dfdate.format(new Date()) + "]" + Thread.currentThread().getName() + str);
    }

    public static void main(String[] args) {
        // 线程数目
        int threadCount = 10;
        // 资源数目
        Semaphore semaphore = new Semaphore(3);
        ExecutorService es = Executors.newFixedThreadPool(threadCount);
        // 启动若干线程
        for (int i = 0; i < threadCount; i++)
            es.execute(new ConsumeResourceTask((i + 1) * 1000, semaphore));
    }
}
