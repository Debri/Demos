package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Liuqi
 * Date: 2017/2/19.
 */
public class SubjectInvocationHandler implements InvocationHandler {
    Object delegate;

    public SubjectInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        method.invoke(delegate, args);
        long end = System.currentTimeMillis();
        System.out.println("任务执行花费了" + (end - start) + "毫秒");
        return null;
    }
}
