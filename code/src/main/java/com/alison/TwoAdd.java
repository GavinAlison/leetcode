package com.alison;

public class TwoAdd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getTwoNumber(ListNode l1, ListNode l2) {
        //preNode
        ListNode dumyHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = dumyHead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;
            int sum = x + y + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry == 1)
            curr.next = new ListNode(1);
        return dumyHead.next;
    }

}
