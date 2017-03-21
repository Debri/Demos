package exam;

/**
 * Created by Liuqi
 * Date: 2017/3/21.
 */
public class LongestDistance {
    public int getDis(int[] A, int n) {
        int distance = 0;
        if (n > 1) {
            int min = A[0];
            for (int i = 1; i < n; i++) {
                if (A[i] - min > distance) {
                    distance = A[i] - min;
                }
                if (min > A[i]) {
                    min = A[i];
                }
            }
        }
        return distance;
    }

    public int getDistance(int[] A, int n) {
        int minNum = A[0];
        int maxDis = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < minNum) {
                minNum = A[i];
            }
            if (A[i] - minNum > maxDis) {
                maxDis = A[i] - minNum;
            }
        }
        return maxDis;
    }
}
