package effective.singleton;

/**
 * Created by Liuqi
 * Date: 2017/3/5.
 */

/**
 * 静态常量
 * 推荐使用
 */
public class Singleton6 {
    private static final Singleton6 singleton = new Singleton6();

    private Singleton6() {
    }

    public Singleton6 getInstance() {
        return singleton;
    }
}
