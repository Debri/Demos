package MyData.heap;

/**
 * Created by Liuqi
 * Date: 2016/9/21
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Element implements Comparable {
    public int compareTo(Object o) {
        return 0;
    }

    private int i = 1;

    public Element() {
        i = 1;
    }

    public Element(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
