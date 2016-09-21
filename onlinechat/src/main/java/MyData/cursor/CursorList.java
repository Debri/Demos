package MyData.cursor;

/**
 * Created by Liuqi
 * Date: 2016/9/18
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 带游标的链表
 */
public class CursorList {
    private int header;
    private static final int SPACE_SIZE = 100;
    public static CursorNode[] cursorNodes;

    static {
        cursorNodes = new CursorNode[SPACE_SIZE];
        for (int i = 0; i < cursorNodes.length; i++) {
            cursorNodes[i] = new CursorNode(null, i + 1);
        }
        cursorNodes[SPACE_SIZE - 1].next = 0;
    }

    private static int alloc() {
        int p = cursorNodes[0].next;
        cursorNodes[0].next = cursorNodes[p].next;
        if (p == 0) {
            throw new OutOfMemoryError();
        }
        return p;
    }

    private static void free(int p) {
        cursorNodes[p].elemnet = null;
        cursorNodes[p].next = cursorNodes[0].next;
        cursorNodes[0].next = p;
    }

    public CursorList() {
        header = alloc();
        cursorNodes[header].next = 0;
    }

    public boolean isEmpty() {
        return cursorNodes[header].next == 0;
    }

    /**
     * 查找
     *
     * @param x
     * @return
     */
    public CursorListItr find(Object x) {
        int itr = cursorNodes[header].next;
        while (itr != 0 && !cursorNodes[itr].elemnet.equals(x)) {
            itr = cursorNodes[itr].next;
        }
        return new CursorListItr(itr);
    }

    public CursorListItr remove(Object x) {
        return null;
        //CursorListItr cli=
    }


}
