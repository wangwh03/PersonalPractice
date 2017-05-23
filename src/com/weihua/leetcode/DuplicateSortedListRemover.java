package com.weihua.leetcode;

import com.weihua.careercup.chapter2.LinkedListUtil;

public class DuplicateSortedListRemover {
    public static void main(String[] args) {
        DuplicateSortedListRemover tester = new DuplicateSortedListRemover();
        tester.deleteDuplicates(null);

        ListNode head = new ListNode(1);
//        tester.deleteDuplicates(head);

        ListNode node2 = new ListNode(1);
        head.next = node2;
//        tester.deleteDuplicates(head);
//        LinkedListUtil.printLinkedListLeetCode(head);

        ListNode node3 = new ListNode(3);
        node2.next = node3;
        tester.deleteDuplicates(head);
        LinkedListUtil.printLinkedListLeetCode(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current;
            while (nextNode != null && nextNode.val == current.val) {
                nextNode = nextNode.next;
            }
            current.next = nextNode;
            current = current.next;
        }

        return head;
    }
}
