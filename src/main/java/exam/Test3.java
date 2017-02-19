package exam;

/**
 * Created by Liuqi
 * Date: 2017/2/17.
 */
public class Test3 {
    static int i=2;
    public  static void   gen(int j){
        System.out.println(i);
        System.out.println(Test3.i);
    }

    public static void main(String[] args) {
        gen(3);
    }

}
