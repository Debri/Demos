package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Liuqi
 * Date: 2016/10/30.
 */
public class VolatileTest {
    public static AtomicInteger count = new AtomicInteger(0);
    //public static int count = 0;
    private static final int THREAD_COUNT = 20;

    public static void increase() {
        System.out.println(count.incrementAndGet());
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
/*        while (Thread.activeCount() > 1) {
            Thread.yield();
        }*/
        System.out.println(count);
    }
}
