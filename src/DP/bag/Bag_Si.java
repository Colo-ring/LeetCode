package DP.bag;

/**
 * @author IntelliYJC
 * @create 2022/4/23 17:43
 * 多重背包
 */
public class Bag_Si {
    private static int N, M; // N 物品数量，M 背包容量
    private static int[] v, w; // 每个物品的体积、价值
    private static int[][] f; // dp 数组，f[i][j] 代表前i个物品容量不超过j的最大价值,
    private static int[] dp;
    private static int[] a, b, s;

    /*// 朴素
    public static void bag() {
        for(int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
    }*/

    public static void bag() {

        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            int k = 1;
            while(k <= s[i]) {
                cnt++;
                v[cnt] = a[i] * k;
                w[cnt] = b[i] * k;
                s[i] -= k;
                k *= 2;
            }
            if(s[i] > 0) {
                cnt++;
                v[cnt] = a[i] * s[i];
                w[cnt] = b[i] * s[i];
            }
        }

        N = cnt;

        for (int i = 1; i <= N; i++) {
            for (int j = M; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
    }

    public static void main(String[] args) {
        N = 4; M = 5;
        int ext = (int) (N * Math.log(N)) + 10;
        v = new int[ext]; w = new int[ext]; // 最多会被拆分成 N * logN
        dp = new int[M + 1]; s = new int[N + 1];

        a = new int[N + 1];
        b = new int[N + 1];
        a[1] = 1; a[2] = 2; a[3] = 3; a[4] = 4;
        b[1] = 2; b[2] = 4; b[3] = 4; b[4] = 5;
        s[1] = 3; s[2] = 1; s[3] = 3; s[4] = 2;

        bag();
        System.out.println(dp[M]);
    }
}
