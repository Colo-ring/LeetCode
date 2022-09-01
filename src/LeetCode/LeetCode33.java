package LeetCode;

public class LeetCode33 {
    public static void main(String[] args) {
        Solution33 ss = new Solution33();
        int res = ss.search(new int[]{3,1}, 1);
        System.out.println(res);
    }
}

class Solution33 {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l >> 1);
            if (arr[m] == target) return m;
            if (arr[m] >= arr[l])
                if (arr[l] <= target && target < arr[m]) r = m - 1;
                else l = m + 1;
            else
                if (arr[m] < target && target <= arr[r]) l = m + 1;
                else r = m - 1;
        }
        return -1;
    }
}
