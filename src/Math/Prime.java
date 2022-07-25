package Math;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/20 15:16
 * 质数
 */
public class Prime {

    // 质数判定
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for(int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 分解质因数
    public static void primeFactorization(int n) {
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    n /= i;
                    s++;
                }
                System.out.println("质因子: " + i + " 次数: " + s);
            }
        }
        if (n > 1) System.out.println("质因子: " + n + " 次数: " + 1);
    }

    // 筛选质数
    /*public static void getPrimes(int n) {
        int[] primes = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++)
            if(!st[i]) {
                primes[cnt++] = i;
                // 只需要删掉所有质数的倍数就行
                for (int j = i + i; j <= n; j += i) st[j] = true;
            }
    }*/

    // 线性筛法
    public static void getPrimes(int n) {
        int[] primes = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) primes[cnt++] = i;
            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                // 保证每个数数是被自己的最小质因子筛掉的
                if(i % primes[j] == 0) break;
            }
        }
    }

    public static void main(String[] args) {
        //primeFactorization(12);
        getPrimes(12);
    }

}
