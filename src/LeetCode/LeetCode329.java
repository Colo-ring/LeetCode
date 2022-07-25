package LeetCode;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/5/9 14:58
 * 329. 矩阵中的最长递增路径
 * 记忆化搜索经典例题
 */
public class LeetCode329 {

    final int N = 210;
    int[][] h, f = new int[N][N];
    int n, m;
    int[] dx = {-1, 0 , 1 ,0}, dy = {0, 1, 0, - 1};



    public int longestIncreasingPath(int[][] matrix) {

        n = matrix.length; m = matrix[0].length;
        h = matrix;
        for (int i = 0; i < N; i++) {
            Arrays.fill(f[i], -1);
        }

        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res = Math.max(res, dp(i, j));
            }
        }

       return res;
    }

    private int dp(int x, int y) {
        if (f[x][y] != -1)  return f[x][y];

        f[x][y] = 1; // 当前状态最小值是1
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            if (a >= 1 && a <= n && b >= 1 && b <= m && h[x - 1][y - 1] < h[a - 1][b - 1]) {
                f[x][y] = Math.max(f[x][y], dp(a, b) + 1);
            }
        }
        return f[x][y];
    }

    public static void main(String[] args) {
        LeetCode329 s = new LeetCode329();
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(s.longestIncreasingPath(matrix));
    }
}
