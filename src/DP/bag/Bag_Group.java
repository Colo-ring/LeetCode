package DP.bag;

/**
 * @author IntelliYJC
 * @create 2022/4/23 23:16
 * 分组背包
 */
public class Bag_Group {
    private static int N, M;
    private static int[] dp,s;
    private static int[][] v,w;

    public static void bag() {
        for(int i = 1; i <= N; i++)
            for (int j = M; j >= 0; j--)
                for(int k = 0; k < s[i]; k++)
                    if(v[i][k] <= j)
                        dp[j] = Math.max(dp[j], dp[j - v[i][k]] + w[i][k]);
    }

    public static void main(String[] args) {
        N = 3; M = 5;
        s = new int[N + 1]; dp = new int[M + 1];
        v = new int[N+1][N+1]; w = new int[N+1][N+1];
        s[1] = 2; s[2] = 1; s[3] = 1;
        v[1][0] = 1; v[1][1] = 2;
        v[2][0] = 3; v[3][0] = 4;
        w[1][0] = 2; w[1][1] = 4;
        w[2][0] = 4; w[3][0] = 5;
        bag();
        System.out.println(dp[M]);
    }
}
