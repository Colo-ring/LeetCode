package Search;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/4/18 22:05
 * 字母全排列
 */
public class Permutation {
    private int n;  // 长度
    private int[] path;  // 路径
    private boolean[] st; // 判断当前数字有没有被访问过
    private Map<Integer, Character> map = new HashMap<>(); // 通过map把题目变成数字全排列

    public void dfs(int u) {
        if (u == n) {  // 搜到最后一层，开始输出
            for(int i = 0; i < n; i ++) {
                System.out.print(map.get(path[i]) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i ++) {
            if(!st[i]) {
                path[u] = i; // 没被访问过，添加到path
                st[i] = true;  // 访问状态设置为true
                dfs(u + 1); // 递归搜索下一层
                st[i] = false; // 还原访问状态
            }
        }
    }

    @Test
    public void testDFS() {
        String s = "abc";
        n = s.length();
        path = new int[n + 1];
        st = new boolean[n + 1];
        for(int i = 1; i <= s.length(); i++) {
            map.put(i, s.charAt(i - 1));
        }
        dfs(0);
    }
}
