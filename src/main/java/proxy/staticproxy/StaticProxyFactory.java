package proxy.staticproxy;

/**
 * Created by Liuqi
 * Date: 2017/2/19.
 */
public class StaticProxyFactory {
    public static Subject getInstance() {
        return new ProxySubject(new RealSubject());
    }
}
