package com.weihua.leetcode;

public class TwoNumberAdder {
    public static void main(String[] args) {
        TwoNumberAdder test = new TwoNumberAdder();
//        System.out.println(test.addTwoNumbers(null, null));
//        System.out.println(test.addTwoNumbers(null, new ListNode(0)));

        ListNode head1 = new ListNode(0);
        ListNode node12 = new ListNode(8);
        head1.next = node12;

        ListNode head2 = new ListNode(6);
        ListNode node22 = new ListNode(7);
        head2.next = node22;

        System.out.println(test.addTwoNumbers(head1, head2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode sum = null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = sum;
        ListNode previousNode = dummyHead;

        ListNode l1Current = l1;
        ListNode l2Current = l2;
        int carrier = 0;
        while (l1Current != null || l2Current != null || carrier != 0) {
            int currentSingleDigitSum = singleDigitSum(l1Current, l2Current, carrier);
            sum = new ListNode(currentSingleDigitSum % 10);
            previousNode.next = sum;
            carrier = currentSingleDigitSum / 10;
            if (l1Current != null) {
                l1Current = l1Current.next;
            }
            if (l2Current != null) {
                l2Current = l2Current.next;
            }
            previousNode = previousNode.next;
        }

        return dummyHead.next;
    }

    private int singleDigitSum(ListNode l1Current, ListNode l2Current, int nextSum) {
        int result = nextSum;

        if (l1Current != null) {
            result += l1Current.val;
        }
        if (l2Current != null) {
            result += l2Current.val;
        }

        return result;
    }
}
