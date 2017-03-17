package DataStructures.tree;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Liuqi
 * Date: 2017/3/15.
 */
public class Test {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL u = new URL("http://you.ctrip.com/place/chengdu104.html");
        InputStream input = u.openStream();

        byte[] buffer = new byte[1024];
        int i = 0;
        while ((input.read(buffer)) != -1) {
            String str = new String(buffer);
            System.out.println(str);
        }
    }
}
