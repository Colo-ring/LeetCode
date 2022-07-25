package DP.bag;

/**
 * @author IntelliYJC
 * @create 2022/4/23 17:07
 * 完全背包
 */
public class Bag_Inf {
    private static int N, M; // N 物品数量，M 背包容量
    private static int[] v, w; // 每个物品的体积、价值
    private static int[][] f; // dp 数组，f[i][j] 代表前i个物品容量不超过j的最大价值
    private static int[] dp;

    /*// 朴素
    public static void bag() {
        for(int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k * v[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
    }*/

    /*// 优化为两重循环
    public static void bag() {
        for(int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                f[i][j] = f[i - 1][j];
                if(j >= v[i]) f[i][j] = Math.max(f[i][j], f[i][j - v[i]] + w[i]);
            }
        }
    }*/

    public static void bag() {
        for(int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= M; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
    }

    public static void main(String[] args) {
        N = 4; M = 5;
        f = new int[N + 1][M + 1];
        v = new int[N + 1]; w = new int[N + 1];
        dp = new int[M + 1];
        v[1] = 1; w[1] = 2; v[2] = 2; w[2] = 4;
        v[3] = 3; w[3] = 4; v[4] = 4; w[4] = 5;
        bag();
        System.out.println(dp[M]);
    }
}
