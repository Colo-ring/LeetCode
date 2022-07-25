package ShortestPath;

import Common.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author IntelliYJC
 * @create 2022/4/14 20:01
 * 优先队列优化的Dijkstra，使得每次寻找最小距离复杂度变成了O(1)
 */
public class DijkstraByHeap {
    private final int N = 510;

    // n表示点，m表示边，实际作为输入。
    private int n = 3, m = 3, idx;
    private int[] dist = new int[N], h = new int[N], w = new int[N], e = new int[N], ne = new int[N];
    private boolean[] st = new boolean[N];

    public void add(int a, int b, int c) { // c边权重
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }

    public int dijkstra()
    {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;

        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::first));
        heap.add(new Pair<>(0, 1));

        while(!heap.isEmpty()) {
            Pair<Integer, Integer> tem = heap.poll();
            int vertex = tem.second(), distance = tem.first();

            if(st[vertex]) continue;

            for(int i = h[vertex]; i != -1; i = ne[i]) {
                int j = e[i];
                if(dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    heap.add(new Pair<>(dist[j], j));
                }
            }
        }

        if(dist[n] == 0x3f3f3f) return -1;
        return dist[n];
    }

    @Test
    public void testDijkstraByHeap(){
        Arrays.fill(h,-1);
        add(1,2,2);
        add(1,3,4);
        add(2,3,1);
        int t = dijkstra();
        System.out.println(t);
    }
}
