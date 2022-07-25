package Search;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/11 16:50
 *
 * N皇后问题
 */
public class NQueen {

    private final int N = 20;
    private final int n = 4;
    private final char[][] g;
    private final boolean[] col, dg, udg; // 列，正对角线，反对角线
    private final boolean[] row; // 方法二中用到

    public NQueen() {
        g = new char[N][N];
        col =  new boolean[N];
        row =  new boolean[N];
        dg = new boolean[N];
        udg = new boolean[N];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }

    }

    // 方法一：类似数字全排列
    void dfs1(int u) {
        if(u == n) {
            show();
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!col[i] && !dg[u + i] && !udg[n - u + i]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs1(u + 1);
                col[i] = dg[u + i] = udg[n - u + i] = false;
                g[u][i] = '.';
            }
        }
    }

    // 方法二：枚举每一个格子，放或者不放
    void dfs2(int x, int y, int s) // x为行，y为列，s为当前皇后数量
    {
        if(y == n) {
            y = 0;
            x++;
        }
        if(x == n) {
            if(s == n) {
                show();
            }
            return;
        }

        // 不放皇后
        dfs2(x, y + 1, s);

        // 放皇后
        if(!row[x] && !col[y] && !dg[x + y] && !udg[x - y + n]) {
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = true;
            dfs2(x, y + 1, s + 1);
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = false;
            g[x][y] = '.';
        }
    }

    private void show() {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void testNQueen() {
        NQueen q = new NQueen();
        //q.dfs1(0);
        q.dfs2(0,0,0);
    }
}
