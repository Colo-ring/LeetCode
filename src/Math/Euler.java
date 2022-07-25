package Math;

/**
 * @author IntelliYJC
 * @create 2022/4/21 14:08
 * 欧拉函数
 */
public class Euler {
    public static int eulerFunc(int n) {
        int res = n;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                // 保证整数
                res = res / i * (i - 1); // 等价于res = res * (1 - 1 / i);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) res = res / n * (n - 1);
        return res;
    }

    // 线性筛法求1~n所有书的欧拉函数
    public static long linearEulerFunc(int n) {
        int[] primes = new int[n + 1], phi = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        int cnt = 0;
        phi[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                phi[i] = i - 1;
            }
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if(i % primes[j] == 0) {
                    // pj是i的质因子，在i前，pj已经被算过了(1 - 1/pj)，因此phi[pj * i]就等于phi[i]乘pj
                    phi[primes[j] * i] = phi[i] * primes[j];
                    break;
                }
                // pj不是i的质因子，因此pj * i的最小质因子就是pj，因此phi[pj * i]就等于phi[i]再多算一个pj，即phi[i]*pj*(1 - 1/pj)
                phi[primes[j] * i] = phi[i] * (primes[j] - 1);
            }
        }
        long res = 0;
        for (int i = 1; i <= n; i++) res += phi[i];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(linearEulerFunc(6));
    }
}
