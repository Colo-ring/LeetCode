package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author IntelliYJC
 * @create 2022/5/11 20:05
 */
public class testXnor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int n = in.nextInt(), k = in.nextInt();
        int t = (int) (Math.pow(2, k) - 1);
        StringBuilder N = new StringBuilder();
        int res = 0;
        for (int i = 0; i < n; i++) {
            N.append(t);
        }

        int m = Integer.parseInt(N.toString());
        for (int i = 0; i < m; i++) {
            if(xnor(i)) res++;
        }
        System.out.println(2 ^ 3);
    }

    private static boolean xnor(int a) {
        while (a > 0) {
            int x = a & 1;
            int y = a >> 1 & 1;
            if (x != y) {
                return false;
            }
            a >>= 1;
        }
        return true;
    }
}