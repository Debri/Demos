package myproxy;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Liuqi
 * Date: 2016/9/26
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class SimpleProxy {
    public void showSystemInfo() {
        Properties pro = System.getProperties();
        /**
         * 遍历Map
         */
        Iterator ite = pro.entrySet().iterator();
        while (ite.hasNext()) {
            Map.Entry entry = (Map.Entry) ite.next();
            Object name = entry.getKey();
            Object value = entry.getValue();
            System.out.println(name + ":" + value);

        }
    }
}
