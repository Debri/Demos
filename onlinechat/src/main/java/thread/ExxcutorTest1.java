package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Liuqi
 * Date: 2017/3/8.
 */
public class ExxcutorTest1 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new CallableTest());
        executorService.shutdown();
        System.out.println(future);

    }
}
