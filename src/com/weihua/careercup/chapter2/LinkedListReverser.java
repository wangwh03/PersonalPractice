package com.weihua.careercup.chapter2;

public class LinkedListReverser {

    public static void main(String[] args) {
        LinkedListReverser reverser = new LinkedListReverser();
        Node head = LinkedListUtil.create();
        Node reversedHead = reverser.reverse(head);
        LinkedListUtil.printLinkedList(reversedHead);
    }
    
    public Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        
        Node previous = null;
        Node current = head;
        Node next = current.getNext();
        while (current.getNext() != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            next = current.getNext();
        }
        
        current.setNext(previous);
        return current;
    }
}
