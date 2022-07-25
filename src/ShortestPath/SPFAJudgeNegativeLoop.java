package ShortestPath;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author IntelliYJC
 * @create 2022/4/14 22:26
 * SPFA 判断负环
 */
public class SPFAJudgeNegativeLoop {
    private final int N = 510;

    // n表示点，m表示边，实际作为输入。
    private int n = 3, m = 3, idx;
    private int[] dist = new int[N], h = new int[N], w = new int[N], e = new int[N], ne = new int[N];
    private int[] cnt = new int[N];
    private boolean[] st = new boolean[N];

    public void add(int a, int b, int c) { // c边权重
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx++;
    }

    public boolean spfa()
    {
        LinkedList<Integer> queue = new LinkedList<>();

        // 不知道从哪个点开始会出现负环，因此把所有点都初始放到队列里
        for(int i = 1; i <= n; i++) {
            queue.push(i);
            st[i] = true;
        }

        while(!queue.isEmpty()) {
            int t = queue.pollFirst();
            st[t] = false;

            for(int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if(cnt[j] >= n) return true;
                    if(!st[j]) {
                        queue.addLast(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void testDijkstraNegLoop(){
        Arrays.fill(h,-1);
        add(1,2,-1);
        add(2,3,4);
        add(3,1,-4);
        if(spfa()) System.out.println("Yes");
        else System.out.println("No");
    }
}
