package other;

/**
 * @author IntelliYJC
 * @create 2022/9/7 17:28
 */
public class TestQuickSort {
    public static void main(String[] args) {

    }

    private void quickSort(int[] arr, int l, int r) {
        int n = arr.length;
        int i = -1, j = n;

        int m = arr[l + r >> 1];

        while(i < j) {
            do i++; while (arr[i] < m);
            do j--;while (arr[j] > m);
        }

        quickSort(arr, l, j); quickSort(arr, j + 1, r);
    }
}
