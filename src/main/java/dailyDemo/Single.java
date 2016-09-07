package dailyDemo;

/**
 * Created by Liuqi
 * Date: 2016/9/2
 * Email:18908356464@163.com
 * Project:test
 */
public class Single {
    private static Single ourInstance = new Single();
    public static Single getInstance() {
        return ourInstance;
    }
    private Single() {
    }
}
