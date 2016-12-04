package effective.singleton;

/**
 * Created by Liuqi
 * Date: 2016/12/3.
 */

/**
 * 通过枚举类实现
 *
 * 它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
public enum Singleton4 {
    INSTANCE;

    public void leaveTheBuilding() {
        //do something
    }
}
