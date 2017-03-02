package exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/2.
 */
public class Main {
    static boolean resolve(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        /*if (sum % 4 != 0) {
            return false;
        }*/
        int temp = 0;
        int num = sum / 4;//假如可以四等分的话的四等分大小
        int j = 0;//数组标志位
        int[] result = new int[3];
        int x = 0;//result 的标志位
        int signal = 0;
        for (int i = 0; i < A.length; i++) {
            temp += A[i];
            //System.out.println(i + "------");
            if (temp == num) {
                result[x++] = i++;
                temp = 0;
            }
        }
        if (result[2] != 0) {
            return true;
        }
        return false;
    }

/*    public static void main(String[] args) {
        Main main = new Main();
        int[] A = {2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7};
        System.out.println(main.resolve(A));
    }*/

    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while (line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if (value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for (int i = 0; i < inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
