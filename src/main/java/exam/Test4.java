package exam;

/**
 * Created by Liuqi
 * Date: 2017/2/28.
 */
public class Test4 {
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
    }
}

class InnerClass {
    private static final int i = 1;

    static {
        System.out.println("b");
        System.out.println(InnerClass.i);
        System.out.println(InnerClass.j);
    }
    private static int j = 2;
    static {
        System.out.println("a");
        System.out.println(InnerClass.i);
        System.out.println(InnerClass.j);
    }
    {
        System.out.println("c");

    }
    public InnerClass() {
        System.out.println("e");
    }

    {
        System.out.println("d");
    }
}
