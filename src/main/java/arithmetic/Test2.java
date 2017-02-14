package arithmetic;

/**
 * Created by Liuqi
 * Date: 2017/2/14.
 */
public class Test2 {
    public static void main(String[] args) {
        int n = 3;
        int res = 1;
        while ((getOnly(n) + res) != n) {
            res += getOnly(n);
            ++n;
        }
        System.out.println(n);
    }

    static int getOnly(int num) {
        int number = 0;
        String s = num + "";
        int len = s.length();
        if (len != 0) {
            for (int i = 0; i < len; i++) {
                char a = s.charAt(i);
                if (a == '1') {
                    number++;

                }
            }
        }
        return number;
    }
}
