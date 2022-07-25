package List;

/**
 * @author IntelliYJC
 * @create 2022/3/31 15:50
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
