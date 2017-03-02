package effective.singleton;

/**
 * Created by Liuqi
 * Date: 2016/12/3.
 */

/**
 * 双重校验锁
 */
public class Singleton5 {
    public volatile static Singleton5 instance;

    private Singleton5() {

    }
    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
