package exam;

import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/27.
 */
public class Main5 {


    public static int byTaxi(int taxiNum, int[][] position) {
        int minDis = position[0][0] + position[0][1];
        int minPosi = 0;
        for (int i = 1; i < taxiNum; i++) {
            if (minDis > position[i][0] + position[i][1]) ;
            minDis = position[i][0] + position[i][1];
            minPosi = i;
        }
        int realTime=minDis;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taxiNum = scanner.nextInt();
        int[][] position = new int[taxiNum][2];
        for (int i = 0; i < taxiNum; i++) {
            position[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < taxiNum; i++) {
            position[i][1] = scanner.nextInt();
        }
        int gx = scanner.nextInt();
        int gy = scanner.nextInt();
        int walkTime = scanner.nextInt();
        int taxiTime = scanner.nextInt();


    }
}
