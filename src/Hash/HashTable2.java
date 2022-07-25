package Hash;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/9 14:11
 * 开放寻址法
 */
public class HashTable2 {

    private int[] h;
    private int N = 200003, NULL = 0x3f3f3f3f;

    public HashTable2() {
        h = new int[N];
        Arrays.fill(h, NULL);
    }

    public int find(int val) {
        int k = (val % N + N) % N;

        while (h[k] != NULL && h[k] != val) {
            k++;
            if(k == N) k = 0;
        }
        return k;
    }
}
