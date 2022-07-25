package MinSpanningTree;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/15 14:19
 */
public class Prim {
    private final int N = 510, INF = 0x3f3f3f;
    private int n = 5, m = 10;  // n表示点，m表示边，实际作为输入。
    private int[][] g = new int[N][N];
    private int[] dist = new int[N];
    private boolean[] st = new boolean[N];

    public int prim() {
        Arrays.fill(dist, INF);
        int res = 0; // 记录最小生成树边的和

        for(int i = 0; i < n; i++) {
            int t = -1;
            for(int j = 1; j <= n; j++) { // 找到集合外，最近的边
                if(!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;
            }
            if(i > 0 && dist[t] == INF) return INF;
            if(i > 0) res += dist[t]; // 先计算res，再更新其他边，防止自环影响
            // 更新dist[j]为j到集合的最短距离g[t][j]
            for(int j = 1; j <= n; j++) dist[j] = Math.min(dist[j], g[t][j]);
            st[t] = true;
        }
        return res;
    }

    @Test
    public void testPrim(){
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) g[i][j] = 0;
                else g[i][j] = INF;
            }
        }
        g[1][2] = g[2][1] = Math.min(g[1][2], 8);
        g[2][2] = g[2][2]  = Math.min(g[2][2], 7);
        g[2][1] = g[1][2]  = Math.min(g[2][1], 1);
        g[3][4] = g[4][3]  = Math.min(g[3][4], 3);
        g[4][4] = g[4][4]  = Math.min(g[4][4], -10);
        g[1][3] = g[3][1]  = Math.min(g[1][3], -9);
        g[5][2] = g[2][5]  = Math.min(g[5][2], -4);
        g[3][1] = g[1][3]  = Math.min(g[3][1], 0);
        g[1][4] = g[4][1]  = Math.min(g[1][4], 8);
        g[4][4] = g[4][4]  = Math.min(g[4][4], 7);

        int t = prim();
        if(t == INF) System.out.println("impossible");
        else System.out.println(t);
    }
}
