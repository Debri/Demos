package dailyDemo;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * Created by Liuqi
 * Date:  2016/9/1
 * Email:18908356464@163.com
 * Package: daliyDemo
 */
public class JettySimple {
    public static void main(String[] args) throws Exception{
        Server server =new Server(8080);
        Context root=new Context(server,"/");
        root.setResourceBase("./pom.xml");
        root.setHandler(new ResourceHandler());
        server.start();
    }
}
