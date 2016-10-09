package mythread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Liuqi
 * Date: 2016/10/9
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), " 111111111").start();
        new Thread(new Waiting(), " 2222222222").start();
        new Thread(new Blacked(), " 33333333").start();
        new Thread(new Blacked(), "444444444 ").start();
        System.out.println(System.currentTimeMillis());
    }

    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Waiting.class.wait();
                    //this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Blacked implements Runnable {
        @Override
        public void run() {
            synchronized (Blacked.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
