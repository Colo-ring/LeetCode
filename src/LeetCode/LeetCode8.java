package LeetCode;

public class LeetCode8 {
    public static void main(String[] args) {
        Solution8 ss = new Solution8();
        ss.myAtoi("9223372036854775808");
    }
}
class Solution8 {
    public int myAtoi(String s) {
        long res = 0;
        long sign = 1;
        int n = s.length();

        if (n == 0) return 0;
        int st = 0;
        while (st < n && s.charAt(st) == ' ') st++;

        if (st == n || !((s.charAt(st) >= '0' && s.charAt(st) <= '9') || s.charAt(st) == '+' || s.charAt(st) == '-')) return 0;
        char first = s.charAt(st);

        if (first == '+' || first == '-') {
            if (first == '-')
                sign = -1;
            st++;
        }

        long aa = Long.MAX_VALUE;


        for (int i = st; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                res = res * 10 + (s.charAt(i) - '0');
            } else break;
        }

        return res * sign > Integer.MAX_VALUE ? Integer.MAX_VALUE : res * sign < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)res * (int)sign;
    }
}