package exam;

/**
 * Created by Liuqi
 * Date: 2017/3/21.
 */
public class Visit {
    public int countPath(int[][] map, int n, int m) {
// 首先找出1和2所在的位置
        int i, j;
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                } else if (map[i][j] == 2) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        if (x1 == x2 && y1 == y2) {// 两点重合
            return 1;
        }
        if (x1 > x2) {// x1,y1用于保存行下标的较小者
            x1 = x1 ^ x2 ^ (x2 = x1);
            y1 = y1 ^ y2 ^ (y2 = y1);
        }
        int dp[][] = new int[n][m];
        if (y1 < y2) {// 两点处在主对角线上
            dp[x1][y1] = 1;
            for (i = x1 + 1; i <= x2; i++) {
                dp[i][y1] = map[i][y1] == -1 ? 0 : dp[i - 1][y1];
            }
            for (j = y1 + 1; j <= y2; j++) {
                dp[x1][j] = map[x1][j] == -1 ? 0 : dp[x1][j - 1];
            }
            for (i = x1 + 1; i <= x2; i++) {
                for (j = y1 + 1; j <= y2; j++) {
                    dp[i][j] = map[i][j] == -1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }
        } else {// 两者处在副对角线上
            dp[x1][y1] = 1;
            for (i = x1 + 1; i <= x2; i++) {
                dp[i][y1] = map[i][y1] == -1 ? 0 : dp[i - 1][y1];
            }
            for (j = y1 - 1; j >= y2; j--) {
                dp[x1][j] = map[x1][j] == -1 ? 0 : dp[x1][j + 1];
            }
            for (i = x1 + 1; i <= x2; i++) {
                for (j = y1 - 1; j >= y2; j--) {
                    dp[i][j] = map[i][j] == -1 ? 0 : dp[i - 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[x2][y2];
    }
}
