package MyData.list;

/**
 * Created by Liuqi
 * Date: 2016/9/20
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ListNode {
    public Object element;
    public ListNode nextNode;

    public ListNode(Object element) {
        this.element = element;
    }

    public ListNode(Object element, ListNode nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }
}
