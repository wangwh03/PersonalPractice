package com.weihua.leetcode;

import com.weihua.careercup.chapter4.TreeNode;
import com.weihua.careercup.chapter4.TreeUtil;

// 1 2 3 4 5
// always choose the median as root
// left side sub problem, right side another subproblem
public class ListToTreeConverter {
    
    public static void main(String[] args) {
        ListToTreeConverter converter = new ListToTreeConverter();
        converter.convert(null);
        
        ListNode n1 = new ListNode(0);
        TreeUtil.printTreeInLevel(converter.convert(n1));
        
    }
    
    public TreeNode convert(ListNode sortedInput) {
        if (sortedInput == null) {
            return null;
        }
        if (sortedInput.next == null) {
            return new TreeNode(sortedInput.val);
        }
        
        ListNode middlePointer = sortedInput;
        ListNode fastPointer = sortedInput.next;
        
        while (fastPointer != null && fastPointer.next != null) {
            middlePointer = middlePointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        TreeNode root = new TreeNode(middlePointer.next.val);
        middlePointer.next = null;
        TreeNode leftChild = convert(middlePointer);
        root.left = leftChild;
        TreeNode rightChild = convert(middlePointer.next.next);
        root.right = rightChild;
        
        return root;
    }
}
