package thread;

/**
 * Created by Liuqi
 * Date: 2017/3/6.
 */
public class Test2 {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = new String("123");
        System.out.println(a == b);
        System.out.println(a.equals(c));
        System.out.println(a == c);
    }
}
