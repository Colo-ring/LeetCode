package LeetCode;

import java.util.PriorityQueue;

/**
 * @author IntelliYJC
 * @create 2022/7/19 10:36
 */
public class LeetCode35 {
     public int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (target <= nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        LeetCode35 s = new LeetCode35();
        System.out.println(s.searchInsert(a, 5));
    }
}
