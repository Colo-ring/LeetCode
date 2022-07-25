package ShortestPath;

import Common.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/4/14 22:02
 */
public class SPFA {
    private final int N = 510;

    // n表示点，m表示边，实际作为输入。
    private int n = 3, m = 3, idx;
    private int[] dist = new int[N], h = new int[N], w = new int[N], e = new int[N], ne = new int[N];
    private boolean[] st = new boolean[N];

    public void add(int a, int b, int c) { // c边权重
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }

    public int spfa()
    {
        Arrays.fill(dist, 0x3f3f3f);
        dist[1] = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(1);
        st[1] = true; // 当前点是否再队列当中，避免重复

        while(!queue.isEmpty()) {
            int t = queue.pollFirst();
            st[t] = false;

            for(int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if(!st[j]) {
                        queue.addLast(j);
                        st[j] = true;
                    }
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
        int t = spfa();
        if(t == -1) System.out.println("impossible");
        else System.out.println(t);
    }
}
