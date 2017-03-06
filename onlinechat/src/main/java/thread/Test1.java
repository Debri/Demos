package thread;

/**
 * Created by Liuqi
 * Date: 2017/3/6.
 */
public class Test1 {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                print();
            }
        };
        //t.run();
        t.start();
        System.out.print("MT");
    }

    static void print() {
        System.out.print("DP");
    }
}
