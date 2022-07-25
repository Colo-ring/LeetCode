package Math;

/**
 * @author IntelliYJC
 * @create 2022/4/21 15:22
 * 快速幂
 */
public class QuickPower {
    // a^k mod p
    public static int qmi(int a, int k, int p) {
        int res = 1;
        while (k > 0) {
            if((k & 1) != 0) res = (int) ((long)res * a % p);
            k >>= 1;
            a = (int) ((long)a * a % p);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(qmi(4, 3, 9));
    }
}
