package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    static int n;
    static String match;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] names = in.nextLine().split(",");
        match = in.nextLine();

        List<String> res = new ArrayList<>();

        for (String name : names) {
            String[] arr = name.split(" ");
            n = arr.length;

            if(dfs(arr, 0, 0, 1)) {
                res.add(name);
            }
        }

        System.out.println(String.join(",", res));
    }

    /**
     * 回溯
     * @param arr 当前姓名以空格split的数组
     * @param u 代表arr中第几个单词
     * @param v 代表match字符串的下标
     * @param l 代表匹配长度
     */
    private static boolean dfs(String[] arr, int u, int v, int l) {
        // 访问到达最后一个单词的下一个位置，代表所有单词都已经匹配成功
        if (u == n) {
            return true;
        }

        // 从0开始的第u个单词，是否与从v开始的match匹配l个长度
        for (int i = 0; i < l; i++, v++) {
            if (arr[u].charAt(i) != match.charAt(v)) {
                return false;
            }
        }

        // 匹配成功后，判断下一个单词是否匹配match的下一个字符
        if (!dfs(arr, u + 1, v, 1)) {
            // 如果下一个单词不匹配match下一个字符，则当前单词重新匹配l+1的长度
            // v需要减l个长度，还原到当前层一开始匹配的match的字符，以重新与arr进行下标对应
            return dfs(arr, u, v - l, l + 1);
        }

        return true;
    }
}
