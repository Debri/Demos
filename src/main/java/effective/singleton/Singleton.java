package effective.singleton;

/**
 * Created by Liuqi
 * Date: 2016/12/3.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 使用容器实现
 */
public class Singleton {
    private static Map<String, Object> map = new HashMap<String, Object>();

    static {
        Singleton singleton = new Singleton();
        map.put(singleton.getClass().getName(), singleton);
    }

    private Singleton() {

    }

    public Singleton getInatance() throws Exception {
        return getInstance(Singleton.class.getName());
    }

    public Singleton getInstance(String key) throws Exception {
        if (map.containsKey(key)) {
            return (Singleton) map.get(key);
        } else {
            Singleton s = (Singleton) Class.forName(key).newInstance();
            map.put(key, s);
            return s;
        }
    }

}
