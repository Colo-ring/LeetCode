package LeetCode;

public class LeetCode5 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String res = s.longestPalindrome("cbbd");
        System.out.println(res);

    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        int left = 0, right = 0;
        for (int c = 0; c < n * 2; c++) {
            int len = 0;
            int l = c >> 1, r = c + 1 >> 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r != l) len++;
                len++;
                l--; r++;
            }
            if (max < len) {
                max = len;
                left = l + 1; right = r;
            }
        }
        return s.substring(left, right);
    }
}