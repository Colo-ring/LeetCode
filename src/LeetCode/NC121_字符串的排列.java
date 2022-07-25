package LeetCode;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/7/17 13:59
 */
public class NC121_字符串的排列 {

    private char[] path;
    private Set<String> set = new HashSet<>();
    private ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation (String str) {
        // write code here
        int n = str.length();
        if (n == 0) return new ArrayList<String>();
        path = new char[n];
        dfs(0, str.toCharArray());
        res.addAll(set);
        return res;
    }

    private void dfs(int u, char[] s) {
        if (u == s.length - 1) {
            set.add(new String(path));
            return;
        }
        for (int i = u; i < s.length; i++) {
            swap(s, i, u);
            dfs(u + 1, s);
            swap(s, i, u);
        }
    }

    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                res[0] = map.get(numbers[i]);
                res[1] = i + 1;
                return res;
            }
            map.put(target - numbers[i], i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strings = line.split(" ");
        String[] first = strings[0].split(",");
        int[] arr = Arrays.stream(first).mapToInt(Integer::valueOf).toArray();
        int target = Integer.parseInt(strings[1]);

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                res[0] = map.get(arr[i]);
                res[1] = i;
                System.out.println(res[0] + "," + res[1]);
                return;
            }
            map.put(target - arr[i], i);
        }
        System.out.println(-1);
    }
}
