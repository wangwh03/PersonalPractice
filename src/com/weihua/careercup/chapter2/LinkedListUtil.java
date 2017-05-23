package com.weihua.careercup.chapter2;

import java.util.Random;

import com.weihua.leetcode.ListNode;

public final class LinkedListUtil {

    public static Node create() {
        Node head = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(5, null);
        
        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        
        return head;
    }
    
    public static Node creatRandom() {
        int numberOfNodes = 5;
        Random randomGenerator = new Random();
        Node[] nodes = new Node[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i] = new Node(randomGenerator.nextInt(10), null);
        }
        for (int i = 0; i < numberOfNodes-1; i++) {
            nodes[i].setNext(nodes[i+1]);
        }  
        return nodes[0];
    }
    
    public static Node create2() {
        int numberOfNodes = 5;
        Node[] nodes = new Node[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i] = new Node(i*2, null);
        }
        for (int i = 0; i < numberOfNodes-1; i++) {
            nodes[i].setNext(nodes[i+1]);
        }
        return nodes[0];
    }
    
    public static Node append(Node head, int valueToInsert) {
        Node newNode = new Node(valueToInsert, null);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        return head;
    }
    
//    public Node delete(Node nodeToDelete) {
//        
//    }
    
    public static Node delete(Node head, int valueToDelete) {
        if (head == null) {
            return null;
        }
        
        if (head.getValue() == valueToDelete) {
            return head.getNext();
        }
        
        Node previous = head;
        Node current = head.getNext();

        do {
            if (current.getValue() == valueToDelete) {
                previous.setNext(current.getNext());
                return head;
            } 
            previous = current;
            current = current.getNext();
        } while (current.getNext() != null);
        
        System.out.println("No value equals to " + valueToDelete + " in this linked list");
        return head;
    }
    
    public static Node search(Node head, int valueToSearch) {
        Node current = head;
        while (current != null) {
            if (valueToSearch == current.getValue()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public static void printLinkedList(Node head) {
        Node current = head;
        while(current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
    
    public static void printLinkedListLeetCode(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
