package LeetCode;

import java.util.*;

/**
 * @author IntelliYJC
 * @create 2022/8/30 12:34
 */
public class LeetCode2392 {
    public static void main(String[] args) {
        Solution2392 ss = new Solution2392();
        int[][] res = ss.buildMatrix(3, new int[][]{{1, 2},{2, 3},{3,1},{2, 3}}, new int[][]{{2, 1}});
        System.out.println(res.toString());
    }
}
class Solution2392 {

    private int n;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        n = k;
        int[][] res = new int[n][n];
        //List<Integer> res = new ArrayList<>();
        int[] row = topSort(rowConditions);
        int[] col = topSort(colConditions);
        if (row.length < n || col.length < n) return new int[0][0];
        for (int i = 1; i <= n; i++) {
            res[find(row, i)][find(col, i)] = i;
        }
        return res;
    }

    private int find(int[] arr, int x) {
        for (int i = 0; i < n; i++) {
            if (x == arr[i]) return i;
        }
        return -1;
    }

    private int[] topSort(int[][] arr) {
        //ArrayList[] g = new ArrayList[n + 1];
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] d = new int[n + 1];
        for (int[] ar : arr) {
            int a = ar[0], b = ar[1];
            List<Integer> cur = g.getOrDefault(a, new ArrayList<>());
            //g.putIfAbsent(a, new ArrayList<Integer>(){{add(b);}});
            cur.add(b);
            g.put(a, cur);
            d[b] ++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            if (d[i] == 0)
                q.addLast(i);
        int idx = 0;
        //int[] res = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int t = q.poll();
            //res[idx++] = t;
            res.add(t);
            for (int u : g.getOrDefault(t, new ArrayList<>())) {
                if (-- d[u] == 0)
                    q.addLast(u);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}