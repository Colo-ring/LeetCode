package Search;

import Queue.MyQueue;
import org.junit.Test;
import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/12 22:00
 *
 * 拓扑排序
 */
public class TopSort {

    final int N = 10;

    int n, m, idx;
    int[] h, e, ne, d;
    MyQueue<Integer> queue = new MyQueue<>(Integer.class, N);

    public TopSort() {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[N];
        ne = new int[N];
        d = new int[N];
    }

    // 在a节点后添加b节点
    public void add(int a, int b)
    {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
        d[b]++;
    }

    public boolean topSort()
    {
        for(int i = 1; i <= n; i ++) {
            if (d[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int t = queue.poll();
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(--d[j] == 0) queue.add(j);
            }
        }
        return queue.allSize() == n;
    }

    @Test
    public void testTopSort() {
        n = 3; m = 3;

        add(1,2);
        add(2,3);
        add(1,3);

        if(topSort()) {
            queue.showAll();
        } else {
            System.out.print("-1");
        }
    }
}
