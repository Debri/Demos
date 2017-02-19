package proxy.staticproxy;

/**
 * Created by Liuqi
 * Date: 2017/2/19.
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = StaticProxyFactory.getInstance();
        proxy.dealTask("吃饭");
    }
}
