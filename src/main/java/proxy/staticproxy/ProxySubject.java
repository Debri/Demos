package proxy.staticproxy;

/**
 * Created by Liuqi
 * Date: 2017/2/19.
 */
public class ProxySubject implements Subject {
    Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void dealTask(String taskName) {
        long start = System.currentTimeMillis();
        subject.dealTask(taskName);
        long end = System.currentTimeMillis();
        System.out.println("执行任务花费了" + (end - start) + "毫秒时间");
    }
}
