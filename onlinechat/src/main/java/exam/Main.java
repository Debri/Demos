package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/4/7.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        if (chars.length != n) {
            return;
        }
        doFind(n, chars);
    }

    public static void doFind(int n, char[] input) {
        int result = 0;
        List<Position> list = new ArrayList<Position>();
        Mix[] mix = new Mix[n];

        for (int i = 0; i < n; i++) {
            Mix m = new Mix();
            m.identity = input[i];
            mix[i] = m;
            if (input[i] >= '1' && input[i] <= '9') {
                int size = input[i] - '0';
                Position position = new Position();
                position.setStart(i - size);
                position.setEnd(i + size);
                list.add(position);
            }
        }
        for (Position p : list) {
            int start = p.getStart() < 0 ? 0 : p.getStart();
            int end = p.getEnd() <= n ? p.getEnd() : n;
            for (int i = start; i < end; i++) {
                if (mix[i].identity == 'X' && mix[i].status == false) {
                    mix[i].status = true;//修改小偷的状态，表示已经被抓
                    result++;//结果加一
                }
            }
        }
        System.out.println(result);
    }
    static class Position {
        public int start;
        public int end;

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public void setStart(int start) {
            this.start = start;
        }
    }

    static class Mix {//包装排队人身份
        char identity;//身份
        boolean status = false;//状态，false表示没有被抓到过
    }

}
