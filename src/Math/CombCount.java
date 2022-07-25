package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/4/22 14:44
 * 组合计数
 */
public class CombCount {

    private static final int N = /*2010*/ 10010, mod = (int)Math.pow(10,9) + 7;
    private static final int[][] c = new int[N][N];
    private static final int[] fact = new int[N], infact = new int[N];
    private static final int p = 7;
    private static final int[] primes = new int[5010], sum = new int[5010]; // sum 每一个质数的次数
    private static final boolean[] st = new boolean[5010];
    private static int cnt;

    // 预处理 c(a,b)=c(a-1,b)+c(a-1,b-1)
    private static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) c[i][j] = 1;
                else c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % mod;
            }
        }
    }

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

    // 卢卡斯定理 C(a,b) 同余 C(a mod p,b mod p) * C(a/p,b/p) (mod p)
    public static int lucas(int a, int b) {
        if(a < p && b < p) return C(a, b);
        return (int) ((long)C(a % p, b % p) * lucas(a / p, b / p) % p);
    }

    // 直接从公式出发计算C a*(a-1)*...*(a-b+1) / b*(b-1)*...*1
    private static int C(int a, int b) {
        int res = 1;
        for (int i = 1, j = a; i <= b; i++, j--) {
            res = (int) ((long)res * j % p);
            res = (int) ((long)res * qmi(i, p - 2 , p));
        }
        return res;
    }

    private static void getPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if(!st[i]) primes[cnt++] = i;
            for(int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) break;
            }
        }
    }

    // 求n!中包含的p的个数
    private static int getP(int n, int p) {
        int res = 0;
        while (n > 0) {
            res += n / p;
            n /= p;
        }
        return res;
    }

    public static void dividComb(int a, int b) {
        getPrimes(a);

        for (int i = 0; i < cnt; i++) {
            int p = primes[i];
            sum[i] = getP(a, p) - getP(b, p) - getP(a - b, p);
        }

        List<Integer> res = new ArrayList<>();
        res.add(1);

        for (int i = 0; i < cnt; i++)
            for(int j = 0; j < sum[i]; j++)
                res = mul(res, primes[i]);

        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i));
        }
    }

    private static List<Integer> mul(List<Integer> a, int b) {
        List<Integer> c = new ArrayList<>();
        int t = 0; // 进位
        for (Integer i : a) {
            t += i * b;
            c.add(t % 10);
            t /= 10;
        }

        while (t > 0) {
            c.add(t % 10);
            t /= 10;
        }
        return c;
    }

    public static void main(String[] args) {
        /*init();
        System.out.println(c[3][1]);
        System.out.println(c[5][3]);
        System.out.println(c[2][2]);*/

        /*init2();
        int a = 5, b = 3;
        System.out.println((long) fact[a] * infact[a - b] % mod * infact[b] % mod);*/

        //System.out.println(lucas(5, 3));

        dividComb(3,1);
    }
}
