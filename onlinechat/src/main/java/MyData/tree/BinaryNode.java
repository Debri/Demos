package MyData.tree;

/**
 * Created by Liuqi
 * Date: 2016/9/18
 * Email: 18908356464@163.com
 * Project: Demos
 */

import static java.lang.Math.max;

/**
 * 查找二叉树实现
 */
public class BinaryNode {

    public Object element;
    public BinaryNode liftChild;
    public BinaryNode rightChild;

    public BinaryNode(Object element, BinaryNode liftChild, BinaryNode rightChild) {
        this.element = element;
        this.liftChild = liftChild;
        this.rightChild = rightChild;
    }

    /**
     * 在查找二叉树中查找
     *
     * @param x
     * @return
     */
    public BinaryNode find(Comparable x, BinaryNode t) {
        if (t == null) {
            return null;
        }
        if (x.compareTo(t.element) < 0) {
            return find(x, t.liftChild);
        } else if (x.compareTo(t.element) > 0) {
            return find(x, t.rightChild);
        } else
            return t;
    }

    /**
     * 在查找二叉树查找最小元素
     */
    public BinaryNode findMin(BinaryNode t) {
        if (t == null) {
            return null;
        } else if (t.liftChild == null) {
            return t;
        }
        return findMin(t.liftChild);
    }

    /**
     * 插入
     */
    public BinaryNode insert(Comparable x, BinaryNode t) {

        if (t == null) {
            t = new BinaryNode(x, null, null);
        } else if (x.compareTo(t.element) < 0) {
            t.liftChild = insert(x, t.liftChild);
        } else if (x.compareTo(t.element) > 0) {
            t.rightChild = insert(x, t.rightChild);
        } else ;
        return t;
    }

    /**
     * 删除节点
     */
    public BinaryNode remeve(Comparable x, BinaryNode t) {
        if (t == null) {
            return t;
        }
        if (x.compareTo(t.element) < 0) {
            t.liftChild = remeve(x, t.liftChild);
        } else if (x.compareTo(t.element) > 0) {
            t.rightChild = remeve(x, t.rightChild);
        } else if (t.liftChild != null && t.rightChild != null) {
            t.element = findMin(t.rightChild).element;
            t.rightChild = remeve(x, t.rightChild);
        } else {
            t = (t.liftChild != null) ? t.liftChild : t.rightChild;
        }
        return t;
    }

    /**
     * 遍历二叉树
     * 中序遍历
     */
    public void printTree(BinaryNode root) {
        if (root != null) {
            printTree(root.liftChild);
            System.out.println(root.element);
            printTree(root.rightChild);
        }
    }

    /**
     * 求树的深度
     */
    public int height(BinaryNode root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + max(height(root.liftChild), height(root.rightChild));
        }
    }

}
