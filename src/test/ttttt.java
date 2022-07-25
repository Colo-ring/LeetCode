package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/4/24 21:25
 */
public class ttttt {

    private static final int N = 100010, mod = (int)Math.pow(10,9) + 7;
    private static final int[] fact = new int[N], infact = new int[N];

    private static int qmi(int a, int k, int p) {
        int res = 1;
        while(k != 0) {
            if((k & 1) != 0) res = (int) ((long)res * a % p);
            a = (int) ((long)a * a % p);
            k >>= 1;
        }
        return res;
    }

    // 预处理 c(a,b) = fact[a] * infact[b-a] * infact[b]
    private static void init2() {
        fact[0] = infact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (int) ((long)fact[i - 1] * i % mod);
            infact[i] = (int) ((long)infact[i - 1] * qmi(i, mod - 2, mod) % mod);
        }
    }

    public static void main(String[] args) {
/*        init2();
        int a = 5, b = 3;
        System.out.println((long) fact[a] * infact[a - b] % mod * infact[b] % mod);*/

        List<Integer> res = new ArrayList<>();

        res.add(2);
        res.add(-1);
        res.add(3);
        res.add(1);

        res.sort((o1, o2) -> o2 - o1);

        System.out.println(res);
    }
}
