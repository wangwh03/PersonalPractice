package com.weihua.leetcode;


// Reverse linked list from m to n, note many special edge cases. 
// what if m is 1
// What if n is equal to larger than list length
public class LinkedListReverserII {

    public static void main(String[] args) {
        LinkedListReverserII reverser = new LinkedListReverserII();
        System.out.println("Testing second reverser method");
        ListNode head2 = new ListNode(1);
        ListNode n22 = new ListNode(2);
        ListNode n23 = new ListNode(3);
        ListNode n24 = new ListNode(4);
        
        reverser.reverse(null, 1, 2);
        reverser.reverse(head2, 1, 2).print();
        
        head2.next = n22;
        reverser.reverse(head2, 1, 2).print();
        
        head2.next = n22;
        n22.next = null;
        reverser.reverse(head2, 2, 3).print();

        
        head2.next = n22;
        n22.next = n23;
        n23.next = null;
        reverser.reverse(head2, 2, 3).print();
        
        head2.next = n22;
        n22.next = n23;
        n23.next = null;
        reverser.reverse(head2, 2, 4).print();
        
        head2.next = n22;
        n22.next = n23;
        n23.next = null;
        reverser.reverse(head2, 2, 5).print();

        head2.next = n22;
        n22.next = n23;
        n23.next = n24;
        reverser.reverse(head2, 1, 6).print();
    }
    
    // Reverse a linked list from node m to node n
    // m and n counts starting from 1
    // p1-> p2->p3 m = 2, n=3, result p1->p3->p2
    public ListNode reverse(ListNode head, int m, int n) {
        if ( m >= n || m < 1) {
            throw new IllegalArgumentException("m must be smaller than n and starting from 1");
        }

        // Get previous starting point
        ListNode previous = null;
        ListNode current = head;
        int counter = 1;
        while (counter < m && current != null) {
            counter++;
            previous = current;
            current = current.next;
        }
        ListNode nodeBeforeReverse = previous;

        // Special case like the regular reverse
        if (current == null || current.next == null) {
            return head;
        } 
        
        // Regular reverse
        ListNode next = current.next;
        previous = null;
        while (next != null && counter <= n) {
            current.next = previous;

            previous = current;
            current = next;
            counter++;
            next = next.next;
        }
        if (next == null && counter <= n) {
            current.next = previous;
        }

        // Set sublist header links
        if (nodeBeforeReverse != null) {
            nodeBeforeReverse.next = current;
            return head;
        } else {
            return current;
        }

    }
}
