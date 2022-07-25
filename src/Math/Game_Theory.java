package Math;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/4/22 20:15
 * 简单博弈论
 */
public class Game_Theory {

    private static final int N = 110, M = 10010;
    private static int n, m;
    private static int[] s = new int[N], f = new int[M]; //

    // true: 先手必胜
    // stones[i]: 第i堆的石子数量
    public static boolean stoneGmae(int[] stones) {
        int res = 0;
        for (int stoneCnt : stones) {
            res ^= stoneCnt;
        }
        return res != 0;
    }

    private static int sg(int x) {
        if(f[x] != -1) return f[x];
        Set<Integer> S = new HashSet<>();

        for (int i = 0; i < m; i ++) {
            int sum = s[i];
            if (x >= sum) S.add(sg(x - sum));
        }

        for(int i = 0; ; i++) {
            if(!S.contains(i)) return f[x] = i;
        }
    }

    public static void main(String[] args) {
        s[0] = 2;
        n = m = 1;
        Arrays.fill(f,-1);

        int res = 0;

        if((res ^ sg(10)) != 0) System.out.println("Yse");
        else System.out.println("No");
    }
}
