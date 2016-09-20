package MyData.list;

/**
 * Created by Liuqi
 * Date: 2016/9/20
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyListItr {
    public ListNode currentNode;

    /**
     * 构造方法
     *
     * @param currentNode
     */
    public MyListItr(ListNode currentNode) {
        this.currentNode = currentNode;
    }

    /**
     * 判断是否为结尾
     *
     * @return
     */
    public boolean isEnd() {
        return currentNode == null;
    }

    /**
     * 将游标移动到下一个
     */
    public void advance() {
        if (!isEnd()) {
            currentNode = currentNode.nextNode;
        }
    }
}
