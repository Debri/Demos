package EmailTest;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/9
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MailWithAttachmentTest {
    @Test
    public void doSendEmail() throws Exception {
        boolean b=true;
        MailWithAttachment m = new MailWithAttachment();
        File att=new File("C:\\Users\\Admin\\Desktop\\course.xlsx");
        m.doSendEmail("zhuti","neirong","2290832242@qq.com",att);
    }

}