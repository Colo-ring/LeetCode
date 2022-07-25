package Math;

import Common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/4/20 23:45
 * 约数
 */
public class Divisor {

    public static List<Integer> getDivisors(int n) {
        List<Integer> res = new ArrayList<>();

        for(int i= 1; i <= n / i; i++) {
            if(n % i == 0) {
                res.add(i);
                if(i != n / i) res.add(n / i);
            }
        }
        res.sort(Integer::compare);
        return res;
    }

    // 获取n的约数的个数
    public static long getDivisorCount(int n) {
        Map<Integer, Integer> primes = new HashMap<>();
        long res = 1;
        final int mod = (int)Math.pow(10, 9) + 7;
        for (int i = 2; i <= n / i; i++) {
            while(n % i == 0) {
                n /= i;
                primes.merge(i, 1, Integer::sum);
            }
        }
        if(n > 1) primes.merge(n, 1, Integer::sum);

        for(int prime : primes.values()) {
            res = res * (prime + 1) % mod;
        }
        return res;
    }

    // 获取n的所有约束的和
    public static long getDivisorSum(int n) {
        Map<Integer, Integer> primes = new HashMap<>();
        long res = 1;
        for (int i = 2; i <= n / i; i++) {
            while(n % i == 0) {
                n /= i;
                primes.merge(i, 1, Integer::sum);
            }
        }
        if(n > 1) primes.merge(n, 1, Integer::sum);

        for(int key : primes.keySet()) {
            int a = primes.get(key);
            long t = 1;
            while(a-- > 0) t = t * key + 1;
            res *= t;
        }
        return res;
    }

    // 求a，b的最大公约数
    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
    // 尾递归内联优化迭代版本
    /*int gcd(int a, int b) {
        if(a < b) return gcd(b, a);
        while(b != 0) {
            int t = a % b;
            a = b; b = t;
        }
        return a;
    }*/

    // 扩展欧几里得算法
    public static int exgcd(int a, int b, Pair<Integer,Integer> pair) {
        if(b == 0) {
            pair.setFirst(1);
            pair.setSecond(0);
            return a;
        }
        pair.swap();
        int d = exgcd(b, a % b, pair);
        pair.swap();
        int y = pair.second(), x = pair.first();
        pair.setSecond(y - a / b * x);
        return d;
    }


    public static void main(String[] args) {
        /*List<Integer> divisors = getDivisors(12);
        System.out.println(divisors);*/

        /*long res = getDivisorSum(12);
        System.out.println(res);*/
        Pair<Integer,Integer> pair = new Pair<>();
        exgcd(8,18, pair);
        System.out.println(pair.first() + " " + pair.second());
        //System.out.println(gcd(6,12));
    }
}
