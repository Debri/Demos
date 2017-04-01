package exam1;

/**
 * Created by Liuqi
 * Date: 2017/4/1.
 */
class TreeNode {
    int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}