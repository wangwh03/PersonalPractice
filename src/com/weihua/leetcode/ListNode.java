package com.weihua.leetcode;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    
    public void print() {

        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + "\t");
            current = current.next;
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return next == null ? val + "" : val + " " + next.val;
    }
    
}
