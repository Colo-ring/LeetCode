package List;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/1 14:55
 */
public class DBListByArray {
    private final int[] e, l, r;
    private final int size;
    private int head, length, idx;

    // 初始化
    public DBListByArray(int n) {
        e = new int[n];
        l = new int[n];
        r = new int[n];
        r[0] = 1; l[1] = 0;
        idx = 2;
        size = n;
        length = 0;
    }

    // 将val插入到下标是k的结点后面
    public void add(int k, int val) {
        e[idx] = val;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        length++;
    }

    // 将下标是k的结点后面的结点删掉
    public void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
        length--;
    }

    public int size() { return size;}

    public int length() { return length;}

    @Override
    public String toString() {
        return "DBListByArray{" +
                "e=" + Arrays.toString(e) +
                ", l=" + Arrays.toString(l) +
                ", r=" + Arrays.toString(r) +
                ", size=" + size +
                ", length=" + length +
                '}';
    }
}
