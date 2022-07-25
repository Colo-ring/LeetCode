package Heap;


/**
 * @author IntelliYJC
 * @create 2022/4/5 22:39
 * 拉链法
 */
public class Heap {

    // h[N]存储堆中的值, h[1]是堆顶，x的左儿子是2x, 右儿子是2x + 1
    // ph[k]存储第k个插入的点在堆中的位置
    // hp[k]存储堆中下标是k的点是第几个插入的
    private int[] heap, ph, hp;

    private int size;

    public Heap(int[] arr) {
        heap = new int[arr.length + 1];
        ph = new int[arr.length + 1];
        hp = new int[arr.length + 1];
        System.arraycopy(arr, 0, heap, 1, arr.length);
        size = arr.length;
    }

    private void create() {
        for (int i = size >> 1; i > 0; i--) {
            down(heap[i]);
        }
    }

    // 交换两个点，及其映射关系
    private void heap_swap(int a, int b) {
        int tem = heap[a];
        heap[a] = heap[b];
        heap[b] = tem;

        tem = ph[hp[a]];
        ph[hp[a]] = ph[hp[b]];
        ph[hp[b]] = tem;

        tem = hp[a];
        hp[a] = hp[b];
        hp[b] = tem;
    }

    public void down(int u) {
        int t = u;
        t = u * 2 <= size && heap[u] > heap[u * 2] ? u : 2 * u;
        t = u * 2 + 1 <= size && heap[u] > heap[u * 2 + 1] ? u : 2 * u + 1;
        if (t != u) {
            int tem = heap[t];
            heap[t] = heap[u];
            heap[u] = tem;
            down(t);
        }
    }

    public void up(int u) {
        while(u / 2 > 0 && heap[u] > heap[u / 2]) {
            int tem = heap[u];
            heap[u / 2] = heap[u];
            heap[u] = tem;
            u /= 2;
        }
    }
}
