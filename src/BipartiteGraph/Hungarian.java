package BipartiteGraph;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/15 16:42
 * 匈牙利算法
 */
public class Hungarian {
    private final int N = 510, M = 100010;
    private int n1 = 2, n2 = 2, m = 4, idx; // n1 男生数量， n2 女生数量， 实际输入匹配边数边数
    private int[] h = new int[N], e = new int[N], ne = new int[N];
    private int[] match = new int[N];
    private boolean[] st = new boolean[N];

    private void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private boolean find(int x) {
        for(int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if(!st[j]) {
                st[j] = true;
                if(match[j] == 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public int hungarian() {
        int res = 0;
        for(int i = 1; i <= n1; i++) {
            Arrays.fill(st, false); // 每次判断男生前，先把妹子状态清空
            if(find(i)) res++;
        }
        return res;
    }

    @Test
    public void testHungarian(){
        Arrays.fill(h, -1);
        // while(m --> 0) 输入
        add(1,1);
        add(1,2);
        add(2,1);
        add(2,2);
        // ==================
        System.out.println(hungarian());
    }
}

