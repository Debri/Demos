package exam1;

import java.util.*;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Liuqi
 * Date: 2017/4/1.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] str1 = scanner.nextLine().split(" ");
        String[] str2 = scanner.nextLine().split(" ");
        scanner.close();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
            arr2[i] = Integer.parseInt(str2[i]);
        }
        TreeNode root = reBuildTree(arr1, arr2);

        doPrint(root);

    }


    public static void doPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.add(root);
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);

                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // System.out.println(node.data);
    }

    public static TreeNode reBuildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }
        return reBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode reBuildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int value = preorder[ps];
        int index = is;
        while (index <= ie && inorder[index] != value) {
            index++;
        }
        if (index > ie) {
            throw new RuntimeException("输入错误");
        }
        TreeNode node = new TreeNode();
        node.data = value;
        node.left = reBuildTree(preorder, ps + 1, ps + index - is, inorder, is, index - 1);
        node.right = reBuildTree(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);
        return node;
    }
}
