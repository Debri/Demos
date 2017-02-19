package proxy.staticproxy;

/**
 * Created by Liuqi
 * Date: 2017/2/19.
 */
public class RealSubject implements Subject {
    public void dealTask(String taskName) {
        System.out.println("执行正在" + taskName + "任务");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
