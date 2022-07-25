package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author IntelliYJC
 * @create 2022/7/25 10:29
 */
public class NC97_字符串出现次数的TopK问题 {
    public String[][] topKstrings (String[] strings, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            map.merge(string, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().
                sorted((o1, o2) -> {
                    int ret = o2.getValue() - o1.getValue();
                    if (ret == 0) {
                        return o1.getKey() .compareTo(o2.getKey());
                    } else {
                        return ret;
                    }
                }).limit(k).collect(Collectors.toList());

        String[][] res = new String[k][2];

        for (int i = 0; i < collect.size(); i++) {
            res[i][0] = collect.get(i).getKey();
            res[i][1] = collect.get(i).getValue().toString();
        }
        return res;
    }

    public static void main(String[] args) {
        NC97_字符串出现次数的TopK问题 s = new NC97_字符串出现次数的TopK问题();
        String[] sts = {"123","123","231","32"};
        String[][] res = s.topKstrings(sts, 2);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
