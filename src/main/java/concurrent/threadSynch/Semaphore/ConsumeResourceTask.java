package concurrent.threadSynch.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liuqi
 * Date: 2017/2/23.
 */
public class ConsumeResourceTask implements Runnable {
    private Semaphore semaphore;
    private int sleepTime;

    /**
     *
     */
    public ConsumeResourceTask(int sleepTime, Semaphore semaphore) {
        this.sleepTime = sleepTime;
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            //获取资源
            semaphore.acquire();
            TaskTest.print(" 占用一个资源...");
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            TaskTest.print(" 资源使用结束，释放资源");
            //释放资源
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
