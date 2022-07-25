package LeetCode;

import List.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author IntelliYJC
 * @create 2022/5/16 15:43
 * 23. 合并K个升序链表
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode head = new ListNode(), tail = head;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = node;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }
        return head.next;
    }

}
