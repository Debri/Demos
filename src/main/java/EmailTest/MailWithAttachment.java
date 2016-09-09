package EmailTest;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Liuqi
 * Date: 2016/9/7
 * Email: 18908356464@163.com
 * Project: test
 */
public class MailWithAttachment {
    private MimeMessage message;
    private Transport transport;
    private  Session session;

    private String host="smtp.163.com";
    private String username= "18908356464@163.com";
    private String password="saiqi1234";
    /**
     * 初始化方法
     */
    public void MailWithAttachment(){
        Authenticator auth = new PopupAuthenticator();
        Properties props=new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.auth",true);
        props.put("username",username);
        props.put("password",password);
        session=Session.getDefaultInstance(props ,auth);
        session.setDebug(true);
        message=new MimeMessage(session);
    }
    /**
     * 发送带附件的邮件
     */
    public void doSendEmail(String topic, String content, String receiver , File attachment) {
        try {
            Address from =new InternetAddress(username);
            message.setFrom(from);
            InternetAddress to =new InternetAddress(receiver);
            //发送到多个用户
            //message.setRecipients(Message.RecipientType.TO,收件人数组);
            //发送到单个用户
            message.setRecipient(Message.RecipientType.TO,to);
            message.setSubject(topic);
            Multipart multipart=new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(content,"text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);

            if (attachment!=null){
                BodyPart attachmentPart = new MimeBodyPart();
                DataSource source=new FileDataSource(attachment);
                attachmentPart.setDataHandler( new DataHandler(source));

                attachmentPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
                multipart.addBodyPart(attachmentPart);

            }

            message.setContent(multipart);
            message.saveChanges();
            transport=session.getTransport("stmp");
            transport.connect(host,username,password);
            System.out.println("_______OK");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (transport!=null){
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    class PopupAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = "pyrgz"; // 163邮箱登录帐号
            String pwd = "123456789"; // 登录密码
            return new PasswordAuthentication(username, pwd);
        }
    }

}
