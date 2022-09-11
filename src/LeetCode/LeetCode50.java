package LeetCode;

public class LeetCode50 {
    public static void main(String[] args) {
        Solution50  ss = new Solution50();
        double res = ss.myPow(2, 10);
        System.out.println(res);
    }
}


class Solution50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        // 偶数
        else if ((n & 1) == 0) return myPow(x * x, n / 2);
        // 基数
        else return (n > 0 ? x : 1.0 / x) * myPow(x * x, n / 2);
    }
}