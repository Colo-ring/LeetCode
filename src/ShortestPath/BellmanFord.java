package ShortestPath;


import Common.Edge;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/14 21:18
 *
 * **适合求只走K个边，从1号点到其他所有点的最短路径。**
 *
 * 1. for： n 次
 *    1. 备份dist数组，防止串联。
 *    2. for 所有边：使用结构体存储 a, b w，代表 a 到 b 的边，权为 w
 *       1. dist[b] = min(dist[b], dist[a] + w);
 */
public class BellmanFord {
    int N = 510, M = 10010;
    int n = 3, m = 3, k = 1; // n代表点，m代表边，k代表最多走k条边
    Edge[] edges = new Edge[M];
    int[] dist = new int[N], backup = new int[N];

    public int bellman_ford() {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;
        for(int i = 0; i < k; i++) {
            backup = dist.clone();
            for(int j = 0; j < m; j++) {
                int a = edges[j].a, b = edges[j].b, w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }

        if(dist[n] > 0x3f3f3f / 2) return -1;
        return dist[n];
    }


    @Test
    public void testBellmanFord() {
        edges[0] = new Edge(1, 2, 1);
        edges[1] = new Edge(2, 3, 1);
        edges[2] = new Edge(1, 3, 3);

        int t = bellman_ford();

        if(t == -1) System.out.println("impossible");
        else System.out.println(t);
    }
}

