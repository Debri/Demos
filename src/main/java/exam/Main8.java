package exam;

        import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/30.
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            doJudge(str);
        }
    }

    public static void doJudge(String str) {
        if (str.length() != 18) {
            System.out.println("ERROR");
            return;
        }
        String result = str.substring(6, 14);
        System.out.println(result);
    }
}
