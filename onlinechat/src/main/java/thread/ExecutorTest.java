package thread;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Liuqi
 * Date: 2017/3/8.
 */
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ScheduledThreadPoolExecutor(2);

        Callable callable = new CallableTest();
     /*   FutureTask<String> future = new FutureTask<String>(callable);
        future.run();
        System.out.println(future.isDone());
        System.out.println(future.get());*/
        Future<String> future1 = executorService.submit(callable);

        System.out.println(future1.get());
        List<Runnable> list = executorService.shutdownNow();
        System.out.println(list);
        for (Runnable run : list) {
            run.run();
            System.out.println("--------");
        }
        System.out.println(future1);
    }
}
