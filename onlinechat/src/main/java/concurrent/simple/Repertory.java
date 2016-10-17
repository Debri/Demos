package concurrent.simple;

/**
 * Created by Liuqi
 * Date: 2016/10/16
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Repertory {
    private static volatile int count = 10;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Consumer(), "consumer");
        Thread thread2 = new Thread(new Producer(), "producer");
        thread1.start();
        thread2.start();
    }

    public void pop() {

    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            count--;
            System.out.println("消费了货物，还有" + count);

        }
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            count++;
            System.out.println("生产了货物，还有" + count);
        }
    }
}



