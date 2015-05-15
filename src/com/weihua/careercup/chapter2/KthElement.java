package com.weihua.careercup.chapter2;
// if k = 1, return the last element, if k = 2, return second last element
public class KthElement {

    public static void main(String[] args) {
        KthElement kthElement = new KthElement();
        Node head = LinkedListUtil.create();
        System.out.println(kthElement.findKthElement(head, 5));
    }
    
    public int findKthElement(Node head, int k) {
        if (head == null || k <= 0) {
            throw new IllegalArgumentException("Empty linked list!");
        }
        
        Node pFast = head;
        int counter = 1;
        while (pFast != null && counter <= k) {
            pFast = pFast.getNext();
            counter++;
        }
        
        if (pFast == null && counter <= k) {
            throw new IllegalArgumentException("K is larger than linked list length!");
        } 
        
        Node pSlow = head;
        while(pFast != null) {
            pFast = pFast.getNext();
            pSlow = pSlow.getNext();
        }
        
        return pSlow.getValue();
    }
}
