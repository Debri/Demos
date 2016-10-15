package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Liuqi
 * Date: 2016/10/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class SemaphoreTest {
    private static ExecutorService pool = Executors.newFixedThreadPool(30);//创建30个线程的线程池
    private static Semaphore semaphore = new Semaphore(10);//设置信号量问10

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //主要方法 获取许可
                        semaphore.acquire();
                        System.out.println("save data");
                        //释放许可
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }
}
