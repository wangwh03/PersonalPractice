package com.weihua.careercup.chapter4;


public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode head) {
        if (head == null) {
            return true;
        }
        
        if (head.getLeft() != null) {
           boolean isLeftBalanced = isBalanced(head.getLeft()); 
           if (!isLeftBalanced) {
               return false;
           }
        }
        
        if (head.getRight() != null) {
            boolean isRightBalanced = isBalanced(head.getRight());
            if (!isRightBalanced) {
                return false;
            }
        }
        
        int leftHeight = getHeight(head.getLeft());
        int rightHeight = getHeight(head.getRight());
        return Math.abs(leftHeight - rightHeight) <= 1;
    }
    
    private int getHeight(TreeNode head) {
        // TODO - empty method
        return 0;
    }
}
