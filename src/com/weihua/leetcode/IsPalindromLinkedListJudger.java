package com.weihua.leetcode;

import java.util.Stack;

// http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
public class IsPalindromLinkedListJudger {
    public static void main(String[] args) {
        IsPalindromLinkedListJudger judger = new IsPalindromLinkedListJudger();
        ListNode head = new ListNode(0);
//        System.out.println(judger.isPalindrome3(head));

        ListNode next2 = new ListNode(0);
        head.next = next2;
        System.out.println(judger.isPalindrome3(head));

        ListNode next3 = new ListNode(1);
        next2.next = next3;
        judger.printLinkedList(head);
//        System.out.println(judger.isPalindrome3(head));

        ListNode next4 = new ListNode(4);
        next3.next = next4;
        judger.printLinkedList(head);
//        System.out.println(judger.isPalindrome3(head));
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int listLength = findLength(head);
        int[] numbers = convertToArray(head, listLength);
        
        for (int i = 0; i < numbers.length / 2; i++) { 
            if (numbers[i] != numbers[listLength - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private int[] convertToArray(ListNode head, int listLength) {
        int[] numbers = new int[listLength];
        int index = 0;
        ListNode current = head;
        while(current !=  null) {
            numbers[index] = current.val;
            index++;
            current = current.next;
        }
        return numbers;
    }
    
    private int findLength(ListNode head) {
        int counter = 0;
        while(head != null) {
            counter++;
            head = head.next;
        }
        
        return counter;
    }
    
    // Use stack
    public boolean isPalindrome2(ListNode head) {
        Stack<ListNode> reversedList = new Stack<>();
        ListNode current = head;
        while(current != null) {
            reversedList.push(current);
            current = current.next;
        }
        
        current = head;
        while(!reversedList.isEmpty()) {
            ListNode reversedNode = reversedList.pop();
            if (reversedNode.val != current.val) {
                return false;
            }
            current = current.next;
        }
        
        return true;
    }
    
    // Reverse part of linked list, compare, then reverse back
    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // get second half head
        ListNode firstTail = getMiddlePoint(head);
        ListNode secondHead = firstTail.next;
        //reverse second part
        ListNode secondTail = reverseLinkedList(secondHead);
        ListNode firstCurrent = head;
        ListNode secondCurrent = secondTail;
        // Note: first half last element still points to second head since we did not set it to be null so use second half != null for stop condition.
        // or set first half tail next to be null and set it back after reverse later.
        while (secondCurrent != null) {
            if (firstCurrent.val != secondCurrent.val) {
                return false;
            }
            firstCurrent = firstCurrent.next;
            secondCurrent = secondCurrent.next;
        }
        // reverse back second part
        reverseLinkedList(secondTail);
        return true;
    }
    
    public ListNode getMiddlePoint(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode mediumPoint = null;
        while (fastPointer != null && fastPointer.next != null) {
            mediumPoint = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return mediumPoint;
    }
    
    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;
        
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        return current;
    }
    
    public  void printLinkedList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
        System.out.println();
    }
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append("value: ").append(val).append(" next: ");
            if (next != null) {
                stringBuilder.append(next.val).toString();
            }
            return stringBuilder.toString();
        }
    }

}


