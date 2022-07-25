package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/5/3 12:32
 * 300. 最长递增子序列
 */
public class LeetCode300 {
    // dp O(N^2)
    /*public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/

    /* 二分 O(NlogN)
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int n : nums) {
            int lsize = list.size();
            if(n > list.get(lsize - 1)) {
                list.add(n);
            } else {
                int l = 0, r = lsize - 1;
                while (l < r)
                {
                    int mid = l + r >> 1;
                    if (list.get(mid) >= n) r = mid;
                    else l = mid + 1;
                }
                list.set(l, n);
            }
        }
        return list.size();
    }*/

    // 数组版二分
    public int lengthOfLIS(int[] nums) {
        int res = 0, n = nums.length;
        int[] list = new int[n];
        list[0] = nums[0];
        for (int x : nums) {
            if (x > list[res]) {
                list[++res] = x;
            } else {
                int l = 0, r = res;
                while (l < r)
                {
                    int mid = l + r >> 1;
                    if (list[mid] >= x) r = mid;
                    else l = mid + 1;
                }
                list[l] = x;
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        LeetCode300 t = new LeetCode300();

        int[] arr = {11,12,13,14,15,6,7,8,101,18};
        System.out.println(t.lengthOfLIS(arr));
    }
}
