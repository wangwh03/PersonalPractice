package com.weihua.leetcode;

import java.util.LinkedList;
import java.util.List;

import com.weihua.careercup.chapter4.TreeNode;

// 
public class BinarySearchTreeSwappedElements {

    public TreeNode fixBST(TreeNode head) {
        if (head == null) {
            return null;
        }
        List<TreeNode> sortedOrder = new LinkedList<TreeNode>();
        // In order traversal BST
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        for (TreeNode node : sortedOrder) {
        }
        return head;
    }
    
    public void inOrderTraversal(TreeNode head, List<TreeNode> sortedOrder) {
        if (head.getLeft() != null) {
            inOrderTraversal(head.getLeft(), sortedOrder);
        }
        sortedOrder.add(head);
        if (head.getRight() != null) {
            inOrderTraversal(head.getRight(), sortedOrder);
        }
    }
    
}
