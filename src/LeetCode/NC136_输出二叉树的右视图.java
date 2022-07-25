package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/7/17 13:15
 */
public class NC136_输出二叉树的右视图 {
    static Map<Integer, Integer> map = new HashMap<>();

    public static int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        dfs(xianxu, zhongxu, 0);
        return map.values().stream().mapToInt(Integer::valueOf).toArray();
    }

    private static void dfs(int[] xianxu, int[] zhongxu, int level) {
        if (xianxu.length == 0 || zhongxu.length == 0) return;
        map.put(level, xianxu[0]);
        for (int i = 0; i < zhongxu.length; i++) {
            if (zhongxu[i] == xianxu[0]) {
                dfs(Arrays.copyOfRange(xianxu, 1, i + 1), Arrays.copyOfRange(zhongxu, 0, i), level + 1);
                dfs(Arrays.copyOfRange(xianxu, i + 1, xianxu.length), Arrays.copyOfRange(zhongxu, i + 1, zhongxu.length), level + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3}, vin = {4,2,5,1,3};
        int[] res = solve(pre, vin);
        for (int r : res) {
            System.out.println(r);
        }
        char[] arr = {'a', 'b'};
        final String reste = String.valueOf(arr).intern();
    }

}
