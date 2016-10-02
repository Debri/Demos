package internet;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/9/24
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class InetTest {
    Inet inet = new Inet();

    @Test
    public void getMyAddr() throws Exception {

        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM-dd");

        String str = sdf.format(currentTime);
        //java.sql.Date date = new java.sql.Date();
        System.out.println(str + "    \n" + sdf);
        //System.out.print(inet.getMyAddr());

    }

    @Test
    public void tectUrl() {
        inet.viewSourceByte("http://172.22.4.2");
    }

    @Test
    public void viewSource2() {
        //inet.sourceView2("http://172.22.4.2");
    }

}