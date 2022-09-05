package LeetCode;

/**
 * @author IntelliYJC
 * @create 2022/9/5 11:23
 */
public class LeetCode41 {
    public static void main(String[] args) {
        Solution41 ss = new Solution41();
        int res = ss.firstMissingPositive(new int[]{-1,4,2,1,9,10});
        System.out.println(res);
    }
}

class Solution41 {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] < n && arr[i] - 1 != arr[arr[i] - 1] - 1) {
                swap(arr, i, arr[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 != i) return i + 1;
        }

        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}