package exam;

/**
 * Created by Liuqi
 * Date: 2017/3/2.
 */
public class Test6 {
    public static void test(String str) {
        if (str.length() > 10000) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        char temp = chars[0];
        int num = 1;
        for (int i = 1; i < chars.length; i++) {
            if (temp == chars[i]) {
                num++;
            } else {
                sb.append(num).append(temp);
                num = 1;
                temp = chars[i];
            }
        }
        sb.append(num).append(temp);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Test6.test("AAAAABCCCCCAA");
    }
}
