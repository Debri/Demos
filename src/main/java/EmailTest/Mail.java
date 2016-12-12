package EmailTest;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by Liuqi
 * Date: 2016/9/7
 * Email: 18908356464@163.com
 * Project: test
 */
public class Mail implements Serializable{
    public static final String Encodeing="utf-8";
    private String sender;
    private String receiver;
    private String username;
    private String password;
    private String host;
    private String topic;
    private String message;
    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public static String getEncodeing() {
        return Encodeing;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        Hashtable
        this.message = message;
    }

}
