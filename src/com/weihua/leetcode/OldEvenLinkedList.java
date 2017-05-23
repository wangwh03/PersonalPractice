package com.weihua.leetcode;

import com.weihua.careercup.chapter2.LinkedListUtil;

public class OldEvenLinkedList {
    public static void main(String[] args) {
        OldEvenLinkedList tester = new OldEvenLinkedList();
        tester.oddEvenList(null);
        ListNode head = new ListNode(1);
//        tester.oddEvenList(head);
        
        ListNode node2 = new ListNode(2);
        head.next = node2;
//        LinkedListUtil.printLinkedListLeetCode(tester.oddEvenList(head));
        
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        LinkedListUtil.printLinkedListLeetCode(tester.oddEvenList(head));

        ListNode node4 = new ListNode(4);
        node3.next = node4;
        LinkedListUtil.printLinkedListLeetCode(tester.oddEvenList(head));
    }
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode secondHalfHead = p2;
        while (p1 != null && p2!=null && p1.next !=null && p2.next !=null) {
            p1.next = p2.next;
            p1 = p1.next;
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = secondHalfHead;
        return head; 
    }
}
