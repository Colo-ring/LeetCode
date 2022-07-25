package ShortestPath;

import org.junit.Test;

/**
 * @author IntelliYJC
 * @create 2022/4/15 13:38
 */
public class Floyd {
    private final int N = 210, INF = 0x3f3f3f;
    private int n = 3, m = 3, Q = 2; // m点，m边，Q询问次数
    private int[][] d = new int[N][N];

    public void floyd() {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
    }

    @Test
    public void testFloyd() {
        for(int i = 1; i <= n; i ++)
            for (int j = 1; j <= n; j++)
                if(i == j) d[i][j] = 0;
                else d[i][j] = INF;

        d[1][2] = 1;
        d[2][3] = 2;
        d[1][3] = 1;

        floyd();

        if(d[2][1] > INF / 2) System.out.println("impossible");
        else System.out.println(d[2][1]);

        if(d[1][3] > INF / 2) System.out.println("impossible");
        else System.out.println(d[1][3]);
    }
}
