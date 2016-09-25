package internet;

import java.io.*;
import java.net.InetAddress;

/**
 * Created by Liuqi
 * Date: 2016/9/25
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Weblog {
    /**
     * 处理服务器的日志文件
     */
    public void weblogHandler(String logPath) {
        try {
            FileInputStream fis = new FileInputStream(new File(logPath));
            Reader reader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(reader);
            String entry;
            while ((entry = br.readLine()) != null) {
                int index = entry.indexOf(" ");
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                InetAddress address = InetAddress.getByName(ip);
                System.out.println(address.getHostName() + theRest);
            }
            br.close();
            reader.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
