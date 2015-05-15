package com.weihua.leetcode;

// Reverse a linked list, classic question
// pay attention to the special cases, and how to initialize previous to avoid handling too many special cases.
public class LinkedListReverser {

    public static void main(String[] args) {
        LinkedListReverser reverser = new LinkedListReverser();
        reverser.reverse(null);
        
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        reverser.reverse(head).print();
        
        head.next = n2;
        reverser.reverse(head).print();
        
        head.next = n2;
        n2.next = n3;
        reverser.reverse(head).print();

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        reverser.reverse(head).print();
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            current.next = previous;

            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;

        return current;
    }

}
