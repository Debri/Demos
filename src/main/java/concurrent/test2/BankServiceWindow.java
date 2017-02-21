package concurrent.test2;

/**
 * Created by Liuqi
 * Date: 2017/2/21.
 */

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * ②共享模式，共享模式采取的例子同样是银行服务窗口，随着此网点的发展，办理业务的人越来越多，一
 * 个服务窗口已经无法满足需求，于是又分配了一位员工开了另外一个服务窗口，这时就可以同时服务两个
 * 人了，但两个窗口都有人占用时同样也必须排队等待，这种服务窗口同步器装置就是一个共享型。第一个
 * 类是共享模式的同步装置类，跟独占模式不同的是它的状态的初始值可以自由定义，获取与释放就是对状
 * 态递减和累加操作。第二个类是测试类，tom、jim和jay再次来到银行，一个有两个窗口甚是高兴，他们
 * 可以两个人同时办理了，时间缩减了不少。
 */
public class BankServiceWindow {
    private final Sync sync;
    public BankServiceWindow(int count) {
        sync = new Sync(count);
    }
    private static class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            setState(count);
        }
        public int tryAcquireShared(int interval) {
            for (;;) {
                int current = getState();
                int newCount = current - 1;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }
        public boolean tryReleaseShared(int interval) {
            for (;;) {
                int current = getState();
                int newCount = current + 1;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }

    public void handle() {
        sync.acquireShared(1);
    }

    public void unhandle() {
        sync.releaseShared(1);
    }

}
