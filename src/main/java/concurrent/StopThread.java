package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by Liuqi
 * Date: 2016/12/13.
 */
public class StopThread {
    private static boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int i = 0;

                if (!stopRequested) {
                    while (true) {
                        System.out.println(++i);
                    }
                }
                /*这样是不允许的导致死循环*/
/*                while (!stopRequested) {
                    i++;
                    System.out.println(i);
                }*/
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

    private static synchronized void stop() {
        stopRequested = true;
    }

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }
}
