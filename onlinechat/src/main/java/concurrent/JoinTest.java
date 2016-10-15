package concurrent;

/**
 * Created by Liuqi
 * Date: 2016/10/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class JoinTest {
    public static void main(String[] args) throws Exception {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2");
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
