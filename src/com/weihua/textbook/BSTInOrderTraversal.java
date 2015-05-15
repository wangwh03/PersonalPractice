package com.weihua.textbook;

import java.util.Stack;

import com.weihua.careercup.chapter4.TreeNode;
import com.weihua.careercup.chapter4.TreeUtil;

public class BSTInOrderTraversal {

    public static void main(String[] args) {
        BSTInOrderTraversal test = new BSTInOrderTraversal();
        
        TreeNode head = TreeUtil.create();
        test.nonRecursive(head);
    }
    
    public void nonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> buffer = new Stack<TreeNode>();
        TreeNode current = root;
        current = getLeftMost(current, buffer);
        
        while (current == null && !buffer.isEmpty()) {
            current = buffer.pop();
            System.out.println(current.getValue());
            current = getLeftMost(current.getRight(), buffer);
        }
    }
    
    private TreeNode getLeftMost(TreeNode current, Stack<TreeNode> buffer) {
        while(current != null) {
            buffer.push(current);
            current = current.getLeft();
        }
        return current;
    }
    
    public void nonRecursiveNoStack(TreeNode root) {
        if (root == null) {
            return;
        }
        
        
    }
}
