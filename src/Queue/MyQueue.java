package Queue;

import java.lang.reflect.Array;

/**
 * @author IntelliYJC
 * @create 2022/4/12 21:37
 *
 * 数组模拟队列，只进行逻辑删除
 */
public class MyQueue<T> {

    private final T[] q;
    private int head, tail = -1, size;

    @SuppressWarnings("unchecked")
    public MyQueue(Class<T> type, int size) {
        q = (T[])Array.newInstance(type, size);
    }

    public void add(T val) {
        q[++tail] = val;
        size++;
    }

    public T getHead() {
        return q[head];
    }

    // 实际并没有删除
    public T poll() {
        size--;
        return q[head ++];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {return size;}

    public int allSize() {return tail + 1;}

    // 展示所有元素
    public void showAll() {
        for (int i = 0; i <= tail; i++) {
            System.out.print(q[i] + " ");
        }
    }

    // 展示逻辑删除后的元素
    public void show() {
        for (int i = head; i <= tail; i++) {
            System.out.print(q[i] + " ");
        }
    }
}
