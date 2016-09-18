package MyData.cursor;

/**
 * Created by Liuqi
 * Date: 2016/9/18
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class CursorNode {
    public Object elemnet;
    public int next;

    public CursorNode(Object theElement) {
        this(theElement, 0);
    }

    public CursorNode(Object theElement, int n) {
        this.elemnet = theElement;
        this.next = n;
    }
}
