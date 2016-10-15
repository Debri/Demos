package concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liuqi
 * Date: 2016/10/15
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 两个线程并行执行 交换数据并交换验证是否相等
 */
public class ExchangerTest {
    private static final Exchanger<String> exchanger = new Exchanger<String>();
    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "xiancheng A";
                try {
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "xiancheng B";
                try {
                    String C = exchanger.exchange(B);
                    System.out.println(B.equals(C) + "   " + "B值 " + B + "  C值 " + C);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.shutdown();
    }
}
