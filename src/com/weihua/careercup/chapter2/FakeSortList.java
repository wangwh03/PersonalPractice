package com.weihua.careercup.chapter2;

public class FakeSortList {

    public static void main(String[] args) {
        FakeSortList fakeSortList = new FakeSortList();
        Node head = LinkedListUtil.creatRandom();
        LinkedListUtil.printLinkedList(head);
        
        Node sortedHead = fakeSortList.sortByX(head, 3);
        LinkedListUtil.printLinkedList(sortedHead);
        
        fakeSortList.sortByX(null, 0);
    }
    
    public Node sortByX(Node head, int x) {
        Node smallList = null;
        Node smallListHead = null;
        Node largeList = null;
        Node largeListHead = null;
        
        Node currentNode = head;
        while(currentNode != null) {
            Node copyOfCurrentNode = new Node(currentNode.getValue(), currentNode.getNext());
            if (currentNode.getValue() <= x) {
                if (smallList == null) {
                    smallListHead = copyOfCurrentNode;
                } else {
                    smallList.setNext(copyOfCurrentNode);
                }
                smallList = copyOfCurrentNode;
            } else {
                if (largeList == null) {
                    largeListHead = copyOfCurrentNode;
                } else {
                    largeList.setNext(copyOfCurrentNode);
                }
                largeList = copyOfCurrentNode;
            }
            currentNode = currentNode.getNext();
        }
        
        if (largeList != null) {
            largeList.setNext(null);
        }
        
        if (smallListHead != null) {
            smallList.setNext(largeListHead);
            return smallListHead;
        } else {
            return largeListHead;
        }
    }
}
