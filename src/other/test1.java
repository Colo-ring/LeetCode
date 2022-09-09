package other;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/9/7 16:00
 * 求一个字符串出现最多的字母和出现次数
 */
public class test1 {
    public static void main(String[] args) {
        String s = "baacacc";

        int[] cnt = new int[26];
        int maxCnt = 0;
        char maxChar = '1';

        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            cnt[cur]++;
            if (cnt[cur] > maxCnt) {
                maxCnt = cnt[cur];
                maxChar = s.charAt(i);
            } else if (cnt[cur] == maxCnt) {
                maxChar = s.charAt(i) < maxChar ? s.charAt(i) : maxChar;
            }
        }

        System.out.println("出现最多的字母：" + maxChar);
        System.out.println(maxChar + " 出现次数：" + maxCnt);
    }
}

