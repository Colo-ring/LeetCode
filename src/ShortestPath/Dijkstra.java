package ShortestPath;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/14 14:36
 * 朴素Dijkstra，适合稠密图，使用邻接矩阵存储
 */
public class Dijkstra {

    private final int N = 510;

    private int n = 3, m = 3;  // n表示点，m表示边，实际作为输入。
    private int[][] g = new int[N][N];
    private int[] dist = new int[N];
    private boolean[] st = new boolean[N];

    public int dijkstra()
    {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;

        for(int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            st[t] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        if(dist[n] == 0x3f3f3f) return -1;
        return dist[n];
    }

    @Test
    public void testDijkstra(){
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == j) g[i][j] = 0;
                else g[i][j] = 0x3f3f3f;
            }
        }
        g[1][2] = 2;
        g[2][3] = 1;
        g[1][3] = 4;
        int t = dijkstra();
        System.out.println(t);
    }
}
