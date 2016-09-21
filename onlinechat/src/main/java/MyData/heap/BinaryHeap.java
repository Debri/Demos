package MyData.heap;

/**
 * Created by Liuqi
 * Date: 2016/9/21
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 二叉堆，用数组实现
 * 假设看作二叉树，根节点小于左右子节点，中序遍历是有序序列
 */
public class BinaryHeap {
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 100;
    private Comparable[] arrays;

    /**
     * 构造方法
     */
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        this.currentSize = 0;
        arrays = new Comparable[capacity + 1];
    }

    /**
     * 将堆置为空
     */
    public void makeEmpty() {
        this.currentSize = 0;
    }

    /**
     * 插入
     */
    public void insert(Comparable ele) {
        if (currentSize >= DEFAULT_CAPACITY) {
            System.out.println("堆满");
            return;
        }
        int hole = ++currentSize;
        for (; hole > 1 && ele.compareTo(arrays[hole / 2]) < 0; hole = hole / 2) {
            arrays[hole] = arrays[hole / 2];
        }
        arrays[hole] = ele;
    }

    /**
     * 查找最小
     */
    public Comparable findMin() {
        return arrays[1];
    }

    /**
     * 删除最小
     */
    public void deleteMin() {
        if (currentSize == 0) {
            System.out.println("堆空");
            return;
        }
        arrays[1] = arrays[currentSize--];
        perolateDown(1);
    }

    /**
     * 下滤操作
     *
     * @param hole 在二叉堆中空的位置
     */
    private void perolateDown(int hole) {
        int child;
        Comparable temp = arrays[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && arrays[child + 1].compareTo(arrays[child]) < 0) {
                child++;
            }
            if (arrays[child].compareTo(temp) < 0) {
                arrays[hole] = arrays[child];
            } else
                break;
        }
        arrays[hole] = temp;
    }

    /**
     * 将一个非二叉堆变成二叉堆
     */
    public void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            perolateDown(i);
        }
    }
}
