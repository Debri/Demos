package MyNio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/10/3
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ChargenClientTest {

    @Test
    public void excuteClient() throws Exception {
        ChargenClient client = new ChargenClient();
        client.excuteClient("rama.poly.edu");
    }


    @Test
    public void test() throws Exception {
        for (byte b = ' '; b < '~'; b++) {
            System.out.println((char) b);
        }
    }

    @Test
    public void input() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer line;
        try {
            str = in.readLine();
            line = new StringTokenizer(str);
            while (line.hasMoreTokens())
                System.out.println(line.nextToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}