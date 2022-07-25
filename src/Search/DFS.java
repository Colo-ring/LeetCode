package Search;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/4/11 14:47
 *
 * 数字全排列
 */
public class DFS {

    private int N = 10, n = 3;
    private int[] path = new int[N];
    private boolean[] st = new boolean[N];

    public void dfs(int u) {
        if (u == n) {
            for(int i = 0; i < n; i ++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i ++) {
            if(!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }

    @Test
    public void testDFS() {
        dfs(0);
    }
}
