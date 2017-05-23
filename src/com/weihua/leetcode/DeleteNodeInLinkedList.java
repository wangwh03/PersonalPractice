package com.weihua.leetcode;

import com.weihua.careercup.chapter2.LinkedListUtil;

public class DeleteNodeInLinkedList {
    public static void main(String[] args) {
        DeleteNodeInLinkedList tester = new DeleteNodeInLinkedList();
        tester.deleteNode(null);
        ListNode head = new ListNode(1);
//        tester.deleteNode(head);
//        LinkedListUtil.printLinkedListLeetCode(head);

        ListNode next2 = new ListNode(2);
        head.next = next2;
        tester.deleteNode(head);
        LinkedListUtil.printLinkedListLeetCode(head);
    }
    
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        } else if (node.next == null) {
            node = null;
            return;
        } 
         
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
