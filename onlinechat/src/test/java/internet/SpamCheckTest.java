package internet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/25
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class SpamCheckTest {
    SpamCheck sc = new SpamCheck();

    @Test
    public void isSpammer() throws Exception {
        assertTrue(!sc.isSpammer("www.baidu.com"));
    }

}