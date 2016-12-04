package effective.singleton;

/**
 * Created by Liuqi
 * Date: 2016/12/3.
 */

/**
 * 懒汉模式
 * 线程安全
 */
public class Singleton1 {
    private static Singleton1 SINGLETON_1;

    public Singleton1() {
    }

    /**
     * 这种写法能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，但是，遗憾的是，效率很低，99%情况下不需要同步。
     * @return
     */
    public static synchronized Singleton1 getInstance() {
        if (SINGLETON_1 == null) {
            SINGLETON_1 = new Singleton1();
        }
        return SINGLETON_1;
    }
}
