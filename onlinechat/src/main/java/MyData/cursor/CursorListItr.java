package MyData.cursor;

/**
 * Created by Liuqi
 * Date: 2016/9/18
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class CursorListItr {
    int current;

    public CursorListItr(int current) {
        this.current = current;
    }

    public boolean isPastEnd() {
        return current == 0;
    }

    public Object retrieve() {
        return isPastEnd() ? null : CursorList.cursorNodes[current].elemnet;
    }

    public void advance() {
        if (!isPastEnd()) {
            current = CursorList.cursorNodes[current].next;
        }
    }

}
