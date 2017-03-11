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
        Subject subject = new RealSubject();//被代理的对象
        InvocationHandler handler = new SubjectInvocationHandler(subject);//将被代理的对象传递给都早方法
        Subject sub = null;
        sub = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        return sub;
    }
}
