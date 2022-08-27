package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/8/26 17:04
 */
public class LeetCode76 {
    public static void main(String[] args) {
        Solution76 s = new Solution76();
        String s1 = s.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s1);
    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mt = new HashMap<>();
        Map<Character, Integer> ms = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mt.put(c, mt.getOrDefault(c, 0) + 1);
        }

        String res = "";
        int cnt = 0;
        // 滑动窗口
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            // s中出现次数++
            ms.put(c, ms.getOrDefault(c, 0) + 1);
            // 如果s中出现次数 <= t中出现次数，说明还未全部覆盖，计数+1
            if (ms.get(c) <= mt.getOrDefault(c, 0)) {
                cnt++;
            }
            // 收缩左指针
            while (i < j &&  ms.get(s.charAt(i)) > mt.getOrDefault(s.charAt(i), 0)) {
                ms.put(s.charAt(i), ms.get(s.charAt(i)) - 1);
                i++;
            }
            if (cnt == t.length()) {
                if (res.length() == 0 || res.length() > j - i + 1) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
