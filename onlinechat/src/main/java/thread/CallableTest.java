package thread;

import java.util.concurrent.Callable;

/**
 * Created by Liuqi
 * Date: 2017/3/8.
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("线程call");
        return "返回";
    }
}
