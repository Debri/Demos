package proxy.dynamicproxy;

import proxy.staticproxy.Subject;

/**
 * Created by Liuqi
 * Date: 2017/2/19.
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy=DynamicProxyFactory.getInstance();
        proxy.dealTask("睡觉");
    }
}
