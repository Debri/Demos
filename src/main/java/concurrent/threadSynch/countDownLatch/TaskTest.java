package concurrent.threadSynch.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liuqi
 * Date: 2017/2/23.
 */
public class TaskTest implements Runnable {

    private CountDownLatch latch;
    private int sleepTime;

    public TaskTest(CountDownLatch latch, int sleepTime) {
        this.latch = latch;
        this.sleepTime = sleepTime;
    }

    public void run() {
        try {
            CountDownLatchTest.print(" is running。");
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            CountDownLatchTest.print(" finished。");
            //计数器减减
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
