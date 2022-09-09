package LeetCode;

/**
 * @author IntelliYJC
 * @create 2022/9/7 16:49
 */
public class LeetCode1122 {
    public static void main(String[] args) {
        Solution1122 ss = new Solution1122();
    }
}
class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[10001];

        for (int a : arr1)
            bucket[a]++;

        int idx = 0;
        for (int b : arr2) {
            while (bucket[b] > 0) {
                bucket[b]--;
                arr1[idx++] = b;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            int c = bucket[i];
            while (c > 0) {
                c--;
                arr1[idx++] = i;
            }
        }

        return arr1;
    }
}