package proxy.dynamicproxyCGlib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Liuqi
 * Date: 2017/3/12.
 */
public class Client {
    public static void main(String[] args) {
        CGlibProxy cGlibProxy = new CGlibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(cGlibProxy);
        RealSubject subject = (RealSubject) enhancer.create();
        subject.sayHello();

    }
}
