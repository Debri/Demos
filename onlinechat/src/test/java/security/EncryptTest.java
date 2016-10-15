package security;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/10/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class EncryptTest {
    @Test
    public void getMD5() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Encrypt.getMD5(String.valueOf(i)).getBytes().toString());
        }
    }
}