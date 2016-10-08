package MyData.tree;

/**
 * Created by Liuqi
 * Date: 2016/10/7
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 平衡二叉树的实现
 */
public class AvlNode {
    public int element;
    public AvlNode left;
    public AvlNode right;
    public int height;

    public AvlNode(int element) {
        this(element, null, null);
    }

    public AvlNode(int element, AvlNode left, AvlNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public static int height(AvlNode tree) {
        return tree == null ? -1 : tree.height;
    }

    public static int max(int x, int y) {
        return x > y ? x : y;
    }

    /**
     * 向平衡二叉树中插入节点，插入后此二叉树仍然平衡
     */
    public AvlNode insert(int x, AvlNode tree) {
        if (tree == null) {
            tree = new AvlNode(x);
        } else if (x < tree.element) {
            tree.left = insert(x, tree.left);
            if (height(tree.left) - height(tree.right) == 2) {
                if (x < tree.left.element) {
                    tree = rotateWithLiftChild(tree);
                } else {
                    tree = doubleWithLeftNide(tree);
                }
            }
        } else if (x > tree.element) {
            tree.right = insert(x, tree.right);
            if (height(tree.right) - height(tree.left) == 2) {
                if (x > tree.right.element) {
                    tree = rotateWithLiftChild(tree);
                } else {
                    tree = doubleWithLeftNide(tree);
                }
            }
        } else ;
        tree.height = max(height(tree.left), height(tree.right)) + 1;
        return tree;
    }

    /**
     * 执行单旋转
     */
    public static AvlNode rotateWithLiftChild(AvlNode tree) {
        AvlNode k = tree.left;
        tree.left = k.right;
        k.right = tree;
        tree.height = max(height(tree.left), height(tree.right)) + 1;
        k.height = max(height(k.left), tree.height) + 1;
        return k;
    }

    /**
     * 执行左右双旋转
     */
    public static AvlNode doubleWithLeftNide(AvlNode tree) {
        tree.left = rotateWithLiftChild(tree.left);
        return rotateWithLiftChild(tree);
    }

    /**
     * 中序遍历
     */
    public void printTree(AvlNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }
    }
}
