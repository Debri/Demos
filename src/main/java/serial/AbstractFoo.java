package serial;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Liuqi
 * Date: 2016/12/14.
 */
public class AbstractFoo {
    private int x, y;

    private final AtomicReference<State> init = new AtomicReference<State>(State.NEW);

    private enum State {

        NEW, INITIALIZING, INITIALIZED;
    }

    protected AbstractFoo() {
    }

    public AbstractFoo(int x, int y) {
        inieialize(x, y);
    }

    protected final void inieialize(int x, int y) {
        if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Already init");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void checkInit() {
        if (init.get() != State.INITIALIZED) {
            throw new IllegalStateException("uninitialized");
        }
    }
}
