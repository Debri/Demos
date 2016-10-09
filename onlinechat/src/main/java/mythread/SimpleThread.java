package mythread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by Liuqi
 * Date: 2016/10/9
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class SimpleThread {


    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] info = threadMXBean.dumpAllThreads(false, false);
        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i].getThreadId() + " :" + info[i].getThreadName() + ":" + info[i].getBlockedTime());

        }
    }
}
