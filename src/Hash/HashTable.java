package Hash;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/9 13:46
 */
public class HashTable {

    private int[] h, e, ne;
    private int N, idx;

    public HashTable(int n) {
        h = new int[n];
        e = new int[n];
        ne = new int[n];
        N = n;
        idx = 0;
        Arrays.fill(h, -1);
    }

    public void insert(int val) {
        int k = (val % N + N) % N;
        e[idx] = val;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    public boolean find(int val) {
        int k = (val % N + N) % N;
        for(int i = h[k]; i != -1; i = ne[i]) {
            if(e[i] == val) {
                return true;
            }
        }
        return false;
    }
}
