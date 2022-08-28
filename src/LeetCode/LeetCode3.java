package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int i = s.lengthOfLongestSubstring(" ");
        System.out.println(i);
    }
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        if (n == 0) return 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int i = 0, j = 1; j < n; j++) {
            while (set.contains(s.charAt(j)))
                set.remove(s.charAt(i++));
            set.add(s.charAt(j));
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}