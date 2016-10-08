package MyData.tree;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liuqi
 * Date: 2016/10/7
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class AvlNodeTest {


    @Test
    public void insert() throws Exception {
        AvlNode left = new AvlNode(0);
        AvlNode right = new AvlNode(40);
        AvlNode tree = new AvlNode(30, left, right);
        /*for (int  i=1;i<=10;i++){
            tree.insert(i,tree);
        }*/
        tree.insert(12, tree);
        tree.printTree(tree);
    }
}