package com.weihua.leetcode;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
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
