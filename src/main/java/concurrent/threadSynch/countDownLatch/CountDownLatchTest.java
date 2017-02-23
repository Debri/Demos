package concurrent.threadSynch.countDownLatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liuqi
 * Date: 2017/2/23.
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        ExecutorService es = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            es.execute(new TaskTest(latch, (i + 1) * 1000));
        }
        try {
            CountDownLatchTest.print(" waiting...");
            //主线程等待其它事件发生
            latch.await();
            //其它事件已发生，继续执行主线程
            CountDownLatchTest.print(" continue。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void print(String str) {
        SimpleDateFormat dfdate = new SimpleDateFormat("HH:mm:ss");
        System.out.println("[" + dfdate.format(new Date()) + "]" + Thread.currentThread().getName() + str);
    }
}
