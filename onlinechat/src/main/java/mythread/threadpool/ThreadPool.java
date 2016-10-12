package mythread.threadpool;

import java.util.IllegalFormatException;

/**
 * Created by Liuqi
 * Date: 2016/10/10
 * Email: 18908356464@163.com
 * Project: Demos
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorkers(int num) throws IllegalFormatException;

    int getJobSize();
}
