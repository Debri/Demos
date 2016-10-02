package http;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/10/2
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyHTTPTest {
    @Test
    public void ececute() throws Exception {
        String path = "D:" + File.separator + "git_01";
        MyHTTP.ececute(path, 80);
    }

}