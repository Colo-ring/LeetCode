package LeetCode;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/5/3 13:40
 * 16. 最接近的三数之和
 */

/*
* 遍历数组，然后双指针，从st =  i + 1 到 ed = length - 1
* sum = nums[i] + nums[st] + nums[ed];
*/
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res =  nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n; i++) {
            int st = i + 1, ed = n - 1;

            while (st < ed) {
                int sum = nums[i] + nums[st] + nums[ed];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum > target) ed--;
                else if (sum < target) st++;
                else return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode16 s = new LeetCode16();
        System.out.println(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
