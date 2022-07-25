package DP.bag;

/**
 * @author IntelliYJC
 * @create 2022/4/23 15:46
 * 0-1背包
 */
public class Bag_0_1 {
    private static int N, M; // N 物品数量，M 背包容量
    private static int[] v, w; // 每个物品的体积、价值
    private static int[][] f; // dp 数组，f[i][j] 代表前i个物品容量不超过j的最大价值

    public static void bag() {

        for(int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                f[i][j] = f[i - 1][j];
                if(j >= v[i]) f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);
            }
        }
    }

    /*
    // 滚动数组优化成为一维
    private static int[] f;
    public static void bag() {
        for(int i = 1; i <= N; i++) {
            for (int j = M; j >= v[i]; j--) {
                // 因为j - v[i] 一定小于 j，
                // 因此  j 从大到小计算，保证每次更新都是 从i - 1层计算
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
    }*/

    public static void main(String[] args) {
        N = 4; M = 5;
        f = new int[N + 1][M + 1];
        v = new int[N + 1]; w = new int[N + 1];
        v[1] = 1; w[1] = 2; v[2] = 2; w[2] = 4;
        v[3] = 3; w[3] = 4; v[4] = 4; w[4] = 5;
        bag();
        System.out.println(f[N][M]);
    }
}
