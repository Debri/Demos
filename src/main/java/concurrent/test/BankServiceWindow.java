package concurrent.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by Liuqi
 * Date: 2017/2/21.
 */

/**
 * 独占模式，独占模式采取的例子是银行服务窗口，假如某个银行网点只有一个服务窗口，那么此银行服
 务窗口只能同时服务一个人，其他人必须排队等待，所以这种银行窗口同步装置是一个独占模型。第一个
 类是银行窗口同步装置类，它按照推荐的做法使用一个继承AQS同步器的子类实现，并作为子类出现。第
 二个类是测试类，形象一点地说，有三位良民到银行去办理业务，分别是tom、jim和jay，我们使用
 BankServiceWindow就可以约束他们排队，一个一个轮着办理业务而避免陷入混乱的局面
 */
public class BankServiceWindow {
    private final Sync sync;

    public BankServiceWindow() {
        sync = new Sync();
    }

    private static class Sync extends AbstractQueuedSynchronizer {
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int releases) {
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    public void handle() {
        sync.acquire(1);
    }

    public void unhandle() {
        sync.release(1);
    }
}
