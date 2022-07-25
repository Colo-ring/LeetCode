package test;

import List.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author IntelliYJC
 * @create 2022/4/24 20:33
 */
public class Solution2 {

    public ListNode solve(ListNode[] a) {
        List<Integer> res = new ArrayList<>();
        ListNode p = new ListNode(-1), head = p;

        for(ListNode list : a) {
            while(list != null) {
                int r = list.val;
                if(!res.contains(r)) {
                    res.add(r);
                }
                list = list.next;
            }
        }

        Optional<Integer> min = res.stream().min(Integer::compare);
        Integer m = min.get();
        int i = res.indexOf(m);
        boolean pre = i - 1 >= 0 && (i + 1 >= res.size() || res.get(i + 1) >= res.get(i - 1));

        if(pre) {

            for(int j = i; j >= 0; j--) {
                p.next = new ListNode(res.get(j));
                p = p.next;
            }
            for(int j = i + 1; j < res.size(); j ++) {
                p.next = new ListNode(res.get(j));
                p = p.next;
            }
        }else {
            for(int j = i + 1; j < res.size(); j ++) {
                p.next = new ListNode(res.get(j));
                p = p.next;
            }
            for(int j = i; j >= 0; j--) {
                p.next = new ListNode(res.get(j));
                p = p.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode head;
        ListNode a1 = new ListNode(-1);
        head = a1;
        ListNode a2 = new ListNode(-2);
        a1.next = a2;
        ListNode a3 = new ListNode(3);
        a2.next = a3;
        ListNode solve = s.solve(new ListNode[]{a1, a2, a3});

        while(solve != null) {
            System.out.println(solve.val);
            solve = solve.next;
        }
    }
}
