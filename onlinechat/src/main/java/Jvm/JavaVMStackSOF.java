package Jvm;

/**
 * Created by Liuqi
 * Date: 2016/10/17
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * java 栈溢出
 */
public class JavaVMStackSOF {
    private int i = 0;

    public void stackLeak() {
        i++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        oom.stackLeak();
    }
}
