package MinSpanningTree;

import Common.Edge;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author IntelliYJC
 * @create 2022/4/15 15:04
 */
public class Kruskal {
    private final int N = 200010;
    private int n = 4, m = 5;  // n表示点，m表示边，实际作为输入。
    private int[] p = new int[N]; // 并查集，每个元素的父节点标号
    private Edge[] edges = new Edge[m];
    private int res, cnt; // res: 最小生成树的边权之和，cnt: 最小生成树的边数。

    private int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public void kruskal() {
        Arrays.sort(edges, Comparator.comparingInt(o -> o.w)); // 按权重从小打到排序

        for(int i = 1; i <= n; i++) p[i] = i; // 初始化并查集
        for(int i = 0; i < n; i++) {
            int a = edges[i].a, b = edges[i].b, w = edges[i].w;
            a = find(a); b = find(b);
            if(a != b) {
                p[a] = b;
                res += w;
                cnt ++;
            }
        }
    }

    @Test
    public void testPrim(){

        edges[0] = new Edge(1,2,1);
        edges[1] = new Edge(1,3,2);
        edges[2] = new Edge(1,4,3);
        edges[3] = new Edge(2,3,2);
        edges[4] = new Edge(3,4,4);

        kruskal();

        if(cnt < n- 1) System.out.println("impossible");
        else System.out.println(res);
    }
}
