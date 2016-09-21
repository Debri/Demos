package MyData.list;

/**
 * Created by Liuqi
 * Date: 2016/9/20
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyList {
    private ListNode head;

    public MyList(ListNode head) {
        this.head = new ListNode(null);
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean idEmpty() {
        return head.nextNode == null;
    }

    /**
     * 将链表职位空
     */
    public void makeEmpty() {
        head.nextNode = null;
    }

    /**
     * 查找
     */
    public ListNodeItr find(Object obj) {
        ListNode ln = head.nextNode;
        while (ln != null && !ln.element.equals(obj)) {
            ln = ln.nextNode;
        }
        return new ListNodeItr(ln);
    }

    /**
     * 移除
     */
    public void remove(Object obj) {
        ListNode ln = head.nextNode;
        while (ln != null && !ln.element.equals(obj)) {
            ln = ln.nextNode;
        }
        ListNodeItr mli = new ListNodeItr(ln);
        if (mli.currentNode.nextNode != null) {
            mli.currentNode.nextNode = mli.currentNode.nextNode.nextNode;
        }
    }

    /**
     * 插入
     */
    public void insert(Object obj, ListNodeItr mli) {
        if (mli != null && mli.currentNode != null) {
            mli.currentNode.nextNode = new ListNode(obj, mli.currentNode.nextNode);
        }
    }

}
