package Hash;

import java.util.Scanner;

/**
 * @author IntelliYJC
 * @create 2022/4/10 14:44
 *
 * 给定一个长度为 n 的字符串，再给定 m 个询问，每个询问包含四个整数 $l_1,r_1,l_2,r_2$，请你判断$[l_1,r_1]$ 和 $[l_2,r_2]$ 这两个区间所包含的字符串子串是否完全相同。
 * 字符串中只包含大小写英文字母和数字。
 *
 * 输入格式
 * 第一行包含整数 n 和 m，标识字符串长度和询问次数。
 * 第二行包含一个长度为 n 的字符串，字符串中只包含大小写英文字母和数字。
 * 接下来 m 行，每行包含四个整数 $l_1,r_1,l_2,r_2$，标识一次询问所涉及的两个区间。
 * 注意，字符串位置从 1 开始编号。
 *
 * 输出格式
 * 队以每个询问输出一个结果，如果两个字符串子串完全相同则输出“Yes”，否则输出“No”。
 * 每个结果占一行。
 *
 * 数据范围
 * 1 <= n,m <= 10^5
 *
 * 输入样例
 * 8 3
 * aabbaabb
 * 1 3 5 7
 * 1 3 6 8
 * 1 2 1 2
 *
 * 输出样例
 * Yse
 * No
 * Yes
 */
public class StringHash {
    private static int N = 100010;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        while(m-- > 0) {
            int l1 = in.nextInt(),r1 = in.nextInt(),l2 = in.nextInt(),r2 = in.nextInt();
            String s1 = str.substring(l1,r1 + 1);
            String s2 = str.substring(l2,r2 + 1);
            System.out.println(s1.hashCode() == s2.hashCode() ? "Yes" : "No");
        }
    }

}
