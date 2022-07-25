package LeetCode;

import org.junit.Test;

import java.util.Objects;

/**
 * @author IntelliYJC
 * @create 2022/5/8 22:27
 * 461. 汉明距离
 */
public class LeetCode461 {
    /*public int hammingDistance(int x, int y) {
        int res = 0;
        while (x > 0 || y > 0) {
            int l = x & 1, r = y & 1;
            if (l != r) res++;
            x >>>= 1; y >>>= 1;
        }

        return res;
    }*/

    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

    @Test
    public void test461() {
        String s = "home:";
        Long l = null;

        System.out.println(Objects.isNull(l));
        String res = s + l;
        System.out.println(res);
    }
}
