package com.weihua.leetcode;

import com.weihua.careercup.chapter2.LinkedListUtil;

public class SwapNodesInPair {

    public static void main(String[] args) {
        SwapNodesInPair tester = new SwapNodesInPair();
        tester.swapPairs(null);

        ListNode head = new ListNode(1);
//        LinkedListUtil.printLinkedListLeetCode(tester.swapPairs(head));

        ListNode node2 = new ListNode(2);
        head.next = node2;
//        LinkedListUtil.printLinkedListLeetCode(tester.swapPairs(head));

        ListNode node3 = new ListNode(3);
        node2.next = node3;
//        LinkedListUtil.printLinkedListLeetCode(tester.swapPairs(head));

        ListNode node4 = new ListNode(4);
        node3.next = node4;
        LinkedListUtil.printLinkedListLeetCode(head);
        LinkedListUtil.printLinkedListLeetCode(tester.swapPairs2(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = p1.next;

        ListNode newHead = p2;


        ListNode previousNode = null;
        while (p1 != null && p1.next != null) {
            p1.next = p2.next;
            p2.next = p1;
            if (previousNode != null) {
                previousNode.next = p2;
            }
            previousNode = p1;
            p1 = p1.next;
            // TODO - previous node null check is lots of extra work here.
            if (p1 != null) {
                p2 = p1.next;
            }
        }

        return newHead;
    }

    // Cleaner recursive solution
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextPair = head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = swapPairs2(nextPair);
        return newHead;
    }
}
