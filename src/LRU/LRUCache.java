package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IntelliYJC
 * @create 2022/7/8 22:20
 */
public class LRUCache {

    private Entry head, tail;
    private int capacity;
    private int size;
    private Map<Integer, Entry> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>(capacity + 2);
        initLinkedList();
    }

    public int get(int key) {
        Entry node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        Entry node = cache.get(key);
        // 已经存在缓存，覆盖value
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        // 不存在
        // 容量满了
        if (size == capacity) {
            Entry lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }
        // 添加新节点
        Entry newNode = new Entry(key, value);
        addNode(newNode);
        cache.put(key, newNode);
        size++;
    }

    private void moveToHead(Entry node) {
        deleteNode(node);
        addNode(node);
    }

    private void deleteNode(Entry node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNode(Entry node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void initLinkedList() {
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    private class Entry {
        public Entry pre;
        public Entry next;
        public int key;
        public int value;

        public Entry() {}

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}


