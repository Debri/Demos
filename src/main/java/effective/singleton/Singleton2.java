package effective.singleton;

/**
 * Created by Liuqi
 * Date: 2016/12/3.
 */

/**
 * 饿汉模式(变种)
 */
public class Singleton2 {
    private static Singleton2 singleton2 = null;

    static {
        singleton2 = new Singleton2();
    }

    public Singleton2() {
    }

    public static Singleton2 getInstance() {
        return singleton2;

    }
}
