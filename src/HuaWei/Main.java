package HuaWei;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/7/25 19:35
 */
public class Main {
    public int[][] count(String s) {
        int[] st = new int[10];
        char[] arr = s.toCharArray();
        String str = "abcdefghijklmnopqrtuvwxy";
        for (char c : arr) {
            if (c == '@') st[1] += 1;
            if (c == '!') st[1] += 2;
            if (c == '.') st[1] += 3;
            if (c == '/') st[1] += 4;
            if (c == 's') st[7] += 4;
            else if (c == 'z') st[9] += 4;
            else {
                int idx = str.indexOf(c);
                if (idx != -1) {
                    st[idx / 3 + 2] += ((idx % 3) + 1);
                }
            }
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < st.length; i++) {
            if (st[i] != 0) {
                res.add(new int[]{i, st[i]});
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Main m = new Main();
        String s  = ".....@@//@!.f";
        int[][] count = m.count(s);
    }
}
