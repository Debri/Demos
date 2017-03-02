package exam;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Liuqi
 * Date: 2017/3/2.
 */
public class Test7 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        int[][] Datas = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Datas[i][j] = scanner.nextInt();
            }
        }
        int maxValue = 0; //水平查找和垂直查找
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - D + 1; j++) {
                int sumLevel = 0;
                int sumHigh = 0;
                for (int k = 0; k < D; k++) {
                    sumLevel = sumLevel + Datas[i][j + k];
                    sumHigh = sumHigh + Datas[j + k][i];
                }
                int temp;
                if (sumHigh > sumLevel) temp = sumHigh;
                else temp = sumLevel;
                if (temp > maxValue) {
                    maxValue = temp;
                }
            }
        } //斜直线查找,讲两次斜线查找看作N-D*N-D的矩阵，分别从左上和右上开始计算
        for (int i = 0; i < N - D + 1; i++) {
            for (int j = 0; j < N - D + 1; j++) {
                int sumL = 0;
                int sumR = 0;
                for (int k = 0; k < D; k++) {
                    sumR = Datas[i + k][N - j - 1 - k] + sumR;
                    sumL = Datas[i + k][j + k] + sumL;
                }
                int temp;
                if (sumR > sumL) temp = sumR;
                else temp = sumL;
                if (temp > maxValue) maxValue = temp;
            }
        }
        System.out.println(maxValue);
    }
}