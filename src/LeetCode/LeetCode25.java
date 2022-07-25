package LeetCode;

import List.ListNode;


/**
 * @author IntelliYJC
 * @create 2022/5/16 17:03
 * 25. K 个一组翻转链表
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = k;
        ListNode next = head;

        // 从head开始找k个节点为当前段，next最终指向下一段的开始
        while (len-- > 0 && next != null)
            next = next.next;

        if(len == -1) {
            // 翻转当前链表
            ListNode a = head, b = head.next;
            while (b != next) {
                ListNode c = b.next;
                b.next = a;
                a = b; b = c;
            }
            // 递归调用
            head.next = reverseKGroup(next, k);
            return a;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] arr = new ListNode[5];

        arr[4] = new ListNode(5, null);
        arr[3] = new ListNode(4, arr[4]);
        arr[2] = new ListNode(3, arr[3]);
        arr[1] = new ListNode(2, arr[2]);
        arr[0] = new ListNode(1, arr[1]);

        ListNode head = arr[0];
        LeetCode25 s = new LeetCode25();
        ListNode res = s.reverseKGroup(head, 3);
        System.out.println(res);

    }
}
