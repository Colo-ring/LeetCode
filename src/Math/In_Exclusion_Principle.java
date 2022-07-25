package Math;

/**
 * @author IntelliYJC
 * @create 2022/4/22 19:19
 * 容斥原理
 */
public class In_Exclusion_Principle {

    //例题：给一个数字n，和一组m个数字p_1,p_2,...,p_m，求 1~n 可以被p_1,p_2,...,p_m整除的个数。
    public static int inExPrinciple(int n, int[] p) {
        int res = 0, m = p.length;
        for (int i = 1; i < 1 << m; i++) {
            int t = 1, cnt = 0; // t:所有p的乘积，cnt: 二进制中1的个数，对应当前集合选取数字的个数
            for (int j = 0; j < m; j++) {
                if ((i >> j & 1) != 0) {
                    cnt++;
                    if((long)t * p[j] > n) {
                        t = -1;
                        break;
                    }
                    t *= p[j];
                }
            }

            if(t != -1) {
                if (cnt % 2 != 0) res += n / t;
                else res -= n/ t;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(inExPrinciple(10, new int[]{7, 2, 5})); // 7
    }
}
