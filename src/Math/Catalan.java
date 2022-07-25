package Math;

/**
 * @author IntelliYJC
 * @create 2022/4/22 18:07
 */
public class Catalan {
    private static final int mod = (int) (Math.pow(10, 9) + 7);

    public static int catalan(int n) {
        int a = 2 * n, b = n;
        int res = 1;
        for(int i = a; i > a - b; i--) res = (int) ((long)res * i % mod);
        for(int i = 1; i <= b; i++) res = (int) ((long)res * QuickPower.qmi(i, mod - 2, mod) % mod);
        res = (int) ((long)res * QuickPower.qmi(n + 1, mod - 2, mod) % mod);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(catalan(3));
    }
}
