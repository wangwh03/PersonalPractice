package com.weihua.leetcode;

// Given two lists that intersect, find the point where they intersect
// Use the two pointer concept twice.  Get each one's length first, and the length difference
// Let the longer one's point move the length difference steps, then both pointer start to move at the same time.  When they meet
//, it is the intersect
public class IntersectionList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA ==null || headB == null) {
            return null;
        }
        ListNode pointA = headA;
        ListNode pointB = headB;

        int lengthA = getLength(pointA);
        int lengthB = getLength(pointB);

        if (lengthA > lengthB) {
            pointA = movePoint(pointA, lengthA-lengthB);
        } else {
            pointB = movePoint(pointB, lengthB-lengthA);
        }

        while (pointA != null && pointA != pointB) {
            pointA = pointA.next;
            pointB = pointB.next;
        }
        return pointA;
    }

    private int getLength(ListNode current) {
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    private ListNode movePoint(ListNode point, int steps) {
        int count = 0;
        while (count < steps) {
            point = point.next;
            count++;
        }
        return point;
    }
}
