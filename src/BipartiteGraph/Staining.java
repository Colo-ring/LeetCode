package BipartiteGraph;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/15 15:59
 * 染色法判断二分图
 */
public class Staining {

    private final int N = 100010, M = 200010;

    private int n = 4, m = 4, idx;
    private int[] h = new int[N], e = new int[N], ne = new int[N];
    private int[] color = new int[N];

    public void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    // u 顶点， c 颜色
    public boolean dfs(int u, int c) {
        color[u] = c;
        for(int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if(color[j] == 0) { // 没有染色
                if(!dfs(j, 3 - c)) return false;
            }
            else if(color[j] == c) return false; // 染色相同有矛盾
        }
        return true;
    }

    @Test
    public void testStaining(){
        Arrays.fill(h,-1);
        add(1,3); add(3,1);
        add(1,4); add(4,1);
        add(2,3); add(3,2);
        add(2,4); add(4,2);

        boolean flag = true;
        for(int i = 1; i <= n; i++) {
            if(color[i] == 0) {
                if(!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) System.out.println("Yes");
        else System.out.println("No");
    }
}
