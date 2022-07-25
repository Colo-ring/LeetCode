package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/5/5 20:41
 * 17. 电话号码的字母组合
 */
public class LeetCode17 {

    static final Map<Character, String> map = new HashMap<>();
    int n;
    List<String> all = new ArrayList<>();
    char[] path;
    List<String> res = new ArrayList<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        n = digits.length();
        path = new char[n];
        if (n == 0) return res;
        for(int i = 0; i < n; i++) {
            String s = map.get(digits.charAt(i));
            all.add(s);
        }
        dfs(0, all);
        return res;
    }

    public void dfs(int u, List<String> all) {
        if(u == n) {
            res.add(String.valueOf(path));
            return;
        }

        String s = all.get(u);
        for(int i = 0; i < s.length(); i++) {
            path[u] = s.charAt(i);
            dfs(u + 1, all);
        }
    }

    @Test
    public void test() {

        StringBuilder sss = new StringBuilder(12);

        sss.append('a');
        sss.append('b');
        sss.append('c');

        System.out.println(sss);

        sss.insert(1,'d');
        sss.insert(0,'d');

        char[] arr = new char[3];

        arr[0] = 'a';
        arr[1] = 'b';
        arr[2] = 'c';

        String s = Arrays.toString(arr);

        System.out.println(sss);
        letterCombinations("23");
    }
}
