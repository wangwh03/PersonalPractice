package com.weihua.leetcode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoLinkedlist {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode previous = dummyHead;
        ListNode current;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current = l1;
                l1 = l1.next;
            } else {
                current = l2;
                l2 = l2.next;
            }
            previous.next = current;
            previous = previous.next;
        }

        if (l1 == null && l2 != null) {
            previous.next = l2;
        } else {
            previous.next = l1;
        }
        return dummyHead.next;
    }
}
