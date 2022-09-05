package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author IntelliYJC
 * @create 2022/9/3 22:02
 */
public class LeetCode215 {
    public static void main(String[] args) {
        Solution215 ss = new Solution215();
        int res = ss.findKthLargest(new int[]{5,2,4,1,3,6,0}, 4);
        System.out.println(res);
        List<Integer> aa = new ArrayList<>();
        aa.add(1);

        Collections.sort(aa);
    }
}


class Solution215 {
    public int findKthLargest(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = arr.length - 1;
        int target = n - k;
        while (l < r) {
            int p = partition(arr, l, r);
            if (p == target) break;
            else if (p < target) l = p + 1;
            else r = p - 1;
        }
        return arr[target];
    }

    private int partition(int[] arr, int l, int r) {
        if (l >= r) return l;
        int m = arr[r];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while(arr[i] <= m);
            do j--; while(arr[j] >= m);
            if (i < j) {
                swap(arr, i, j);
            }
            i++; j--;
        }
        //swap(arr, l, j);
        return i;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}