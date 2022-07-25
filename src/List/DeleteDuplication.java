package List;

import org.junit.Test;

/**
 * @author IntelliYJC
 * @create 2022/3/31 15:51
 * 删除链表中重复的节点
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return null;
        if(pHead.next == null) return pHead;
        ListNode realHead = new ListNode(-1);
        realHead.next = pHead;

        ListNode pre = realHead;
        ListNode p = pHead;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while(p != null && p.val == val){
                    p = p.next;
                }
                pre.next = p;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return realHead.next;
    }

    @Test
    public void test(){
        int[] list = new int[]{1,2,3,3,4,4,5};
        ListNode head = new ListNode(list[0]);
        ListNode tail = head;
        for(int i = 1; i < list.length; i++){
            ListNode newNode = new ListNode(list[i]);
            tail.next = newNode;
            tail = newNode;
        }

        ListNode res = deleteDuplication(head);
    }
}


