package com.weihua.careercup.chapter2;

public class AddTwoList {

    public static void main(String[] args) {
        AddTwoList adder = new AddTwoList();
        
        LinkedListUtil.printLinkedList(null);
        
        Node head1 = LinkedListUtil.create();
        LinkedListUtil.printLinkedList(adder.add(head1, null));
        
        Node head2 = LinkedListUtil.create2();
        LinkedListUtil.printLinkedList(adder.add(head2, null));
        
        head1 = LinkedListUtil.create();
        head2 = LinkedListUtil.create();
        Node sumHead = adder.add(head1, head2);
        LinkedListUtil.printLinkedList(sumHead);
    }
    
    public Node add(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        
        if (head2 == null) {
            return head1;
        }
        

        Node current1 = head1;
        Node current2 = head2;
        Node dummyHead = new Node(0, null);
        Node previosuSum = dummyHead;
        int carrier = 0;
        while (current1 != null || current2 != null) {
            int value1 = current1 == null ? 0 : current1.getValue();
            int value2 = current2 == null ? 0 : current2.getValue();
            
            int currentSumValue = value1 + value2 + carrier;
            carrier = currentSumValue / 10;
            Node currentSum = new Node(currentSumValue % 10, null);
            previosuSum.setNext(currentSum);
            previosuSum = currentSum;
            
            if (current1 != null) {
                current1 = current1.getNext();
            }
            if (current2 != null) {
                current2 = current2.getNext();
            }
        }

        if (carrier != 0) {
            previosuSum.setNext(new Node(carrier, null));
        }
        
        return dummyHead.getNext();
    }
}
