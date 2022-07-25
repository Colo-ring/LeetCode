package ByteDance;

/**
 * @author IntelliYJC
 * @create 2022/7/9 12:23
 */
public class NC88_寻找第K大 {
    public int findKth(int[] a, int n, int K) {
        return quickFind(a, 0, n - 1, K);
    }

    private int quickFind(int[] a, int l, int r, int k) {
        int i = l, j = r, x = a[l + r >> 1];
        while (i < j) {
            while(i < j && a[j] >= x) j--;
            if (i < j) a[i++] = a[j];
            while(i < j && a[i] <= x) i++;
            if (i < j) a[j--] = a[i];
        } // 5,6,5,11,12,13,13
        a[i] = x;
        int gap = r - i + 1;
        if (gap == k) {
            return x;
        } else if (gap > k) {
            return quickFind(a, i + 1, r, k);
        } else {
            return quickFind(a, l, i - 1, k - gap);
        }
    }

    public static void main(String[] args) {
        NC88_寻找第K大 s = new NC88_寻找第K大();
        int[] a = {13,11,5,6,12,13,5};
        int kth = s.findKth(a, 7, 4);
        System.out.println(kth);
    }
}
