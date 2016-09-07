package EmailTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/7
 * Email: 18908356464@163.com
 * Project: test
 */
public class EmailUtilTest {
    @Test
    public void send() throws Exception {
        Mail mail=new Mail();
        mail.setSender("18908356464@163.com");
        mail.setReceiver("2290832242@qq.com");
        mail.setHost("smtp.163.com");
        mail.setUsername("18908356464@163.com");
        mail.setPassword("saiqi1234");
        mail.setMessage("ceshi");
        mail.setTopic("simpleTest");
        mail.setPort("465");
        EmailUtil emailUtil = new EmailUtil();
     emailUtil.send(mail);

    }


}