package List;

import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/1 14:15
 */
public class ListByArray {
    private final int[] e, ne;
    private final int size;
    private int head, length, idx;

    // 初始化
    public ListByArray(int n) {
        head = -1;
        idx = 0;
        length = 0;
        size = n;
        e = new int[n];
        ne = new int[n];
    }

    // 将val插入到头节点
    public void addToHead(int val) {
        e[idx] = val;
        ne[idx] = head;
        head = idx++;
        length++;
    }

    // 将val插入到下标是k的结点后面
    public void add(int k, int val) {
        e[idx] = val;
        ne[idx] = ne[k];
        ne[k] = idx++;
        length++;
    }

    // 将下标是k的结点后面的结点删掉
    public void remove(int k) {
        ne[k] = ne[ne[k]];
        length--;
    }

    public int size() { return size;}

    public int length() { return length;}

    @Override
    public String toString() {
        return "ListByArray{" +
                "e=" + Arrays.toString(e) +
                ", ne=" + Arrays.toString(ne) +
                ", size=" + size() +
                ", length=" + length() +
                '}';
    }
}
