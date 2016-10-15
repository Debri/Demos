package concurrent;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Liuqi
 * Date: 2016/10/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class WaterBankService implements Runnable {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);
    private Executor pool = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String, Integer> sheet = new ConcurrentHashMap<String, Integer>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    sheet.put(Thread.currentThread().getName(), 2);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> entry : sheet.entrySet()) {
            result += entry.getValue();
            System.out.println(result);
        }
        sheet.put("result", result);
        System.out.println("结果" + result);
    }

    public static void main(String[] args) {
        WaterBankService service = new WaterBankService();
        service.count();
    }
}
