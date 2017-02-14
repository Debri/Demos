package EmailTest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.util.logging.Logger;


/**
 * Created by Liuqi
 * Date: 2016/9/7
 * Email: 18908356464@163.com
 * Project: test
 */

public  class EmailUtil { 
    protected final Logger logger= Logger.getLogger(this.getClass().getName());

    public boolean send(Mail mail) {
        HtmlEmail email =new HtmlEmail();
        try {
            email.setHostName(mail.getHost());
            email.setCharset(Mail.getEncodeing());
            email.addTo(mail.getReceiver());
            email.setFrom(mail.getSender(), mail.getUsername());
            email.setAuthentication(mail.getUsername(),mail.getPassword());
            email.setSubject(mail.getTopic());
            email.setMsg(mail.getMessage());
            email.setSslSmtpPort(mail.getPort());
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
           logger.info("发送失败");
            return  false;
        }
    }
}
