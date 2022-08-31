package LeetCode;
import java.util.*;


public class LeetCode15 {
    public static void main(String[] args) {
        Solution15 ss = new Solution15();
        List<List<Integer>> lists = ss.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        int a = 0;
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == 0) {
                    int a = i, b = l, c = r;
                    res.add(new ArrayList<Integer>(){{add(arr[a]); add(arr[b]); add(arr[c]);}});
                    int prel = arr[l++], prer = arr[r--];
                    while (l < n && arr[l] == prel) l++;
                    while (r >= 0 && arr[r] == prer) r--;
                } else if (sum < 0) {
                    l++;
                } else r--;
            }
        }
        return res;
    }
}
