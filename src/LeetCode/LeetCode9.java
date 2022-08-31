package LeetCode;

/**
 * @author IntelliYJC
 * @create 2022/8/30 15:25
 */
public class LeetCode9 {
    public static void main(String[] args) {
        Solution9 ss = new Solution9();
        boolean palindrome = ss.isPalindrome(1000021);
        System.out.println(palindrome);
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int l = 10, r = 10;
        while (l < x) l *= 10;
        l /= 10;

        while (x > 0) {
            if (x % r != x / l) {
                return false;
            }
            x %= l;
            x /= r;
            l /= 100;
        }
        return true;
    }
}