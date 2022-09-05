package LeetCode;

public class LeetCode43 {
    public static void main(String[] args) {
        Solution43 ss = new Solution43();
        String res = ss.multiply("6", "501");
        System.out.println(res);
    }
}


class Solution43 {
    public String multiply(String num1, String num2) {

        if("0".equals(num1) || "0".equals(num2)) return "0";

        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();

        int[] mul = new int[a.length + b.length];
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                int t = (a[i] - '0') * (b[j] - '0');
                t += mul[i + j + 1];

                mul[i + j] += t / 10;
                mul[i + j + 1] = t % 10;
            }
        }

        StringBuilder s = new StringBuilder();
        for (int k = mul[0] == 0 ? 1 : 0; k < mul.length; k++)
            s.append(mul[k]);

        return s.toString();
    }
}