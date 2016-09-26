package myproxy;

import org.junit.Test;

/**
 * Created by Liuqi
 * Date: 2016/9/26
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class simpleProxyTest {
    SimpleProxy pro = new SimpleProxy();

    @Test
    public void showSystemInfo() throws Exception {
        pro.showSystemInfo();
    }

}