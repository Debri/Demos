package effective.singleton;

/**
 * Created by Liuqi
 * Date: 2016/12/3.
 */

/**
 * 静态内部类方式
 */
public class Singleton3 {
    /**
     * 将构造方法声明为私有
     */
    private Singleton3() {

    }

    public static final Singleton3 getInstance() {
        return SingletonHandler.singleton;
    }

    /**
     * 内部类，用于构造外部类实例
     */
    public static class SingletonHandler {
        private static final Singleton3 singleton = new Singleton3();
    }

}
