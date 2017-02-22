package proxy.dynamicproxy;

import proxy.staticproxy.RealSubject;
import proxy.staticproxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Liuqi
 * Date: 2017/2/19.
 */
public class DynamicProxyFactory {
    public static Subject getInstance() {
        Subject subject = new RealSubject();
        InvocationHandler handler = new SubjectInvocationHandler(subject);
        Subject proxy = null;
        proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        return proxy;
    }
}