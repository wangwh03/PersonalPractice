package com.weihua.leetcode;

import com.weihua.careercup.chapter1.MatrixRotator;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree tester = new BalancedBinaryTree();
        System.out.println(tester.isBalanced(null));
        TreeNode head = new TreeNode(1);
        System.out.println(tester.isBalanced(head));

        TreeNode left1 = new TreeNode(2);
        head.left = left1;
        TreeNode left2 = new TreeNode(3);
        left1.left = left2;
        System.out.println(tester.isBalanced(head));
    }

    // Recursively make sure every nodes' left subtree length and right subtree length has no more than 1 difference
    // Use -1 to mean unbalanced, or throw exceptions
    public boolean isBalanced(TreeNode root) {
        try{
            isBalancedHelper(root);
            return true;
        } catch (UnbalancedException e) {
            return false;
        }
    }

    private int isBalancedHelper(TreeNode root) throws UnbalancedException {
        if (root == null) {
            return 0;
        }
        int leftLength = isBalancedHelper(root.left);
        int rightLength = isBalancedHelper(root.right);
        if (leftLength < 0 || rightLength < 0 || Math.abs(leftLength - rightLength) > 1) {
            throw new UnbalancedException("Unbalance detected");
            // return -1;
        }
        return Math.max(leftLength, rightLength) + 1;
    }

    private class UnbalancedException extends Exception {
        public UnbalancedException(String message) {
            super(message);
        }
    }
//    private TreeResult isBalancedHelper(TreeNode root) {
//        if (root == null) {
//            return new TreeResult(true, 0);
//        }
//
//        TreeResult leftResult = isBalancedHelper(root.left);
//        if (!leftResult.isBalanced) {
//            return new TreeResult(false, leftResult.height+1);
//        }
//
//        TreeResult rightResult = isBalancedHelper(root.right);
//        if (!rightResult.isBalanced) {
//            return new TreeResult(false, rightResult.height+1);
//        }
//
//        if (Math.abs(leftResult.getHeight() - rightResult.getHeight()) > 1) {
//            return new TreeResult(false, Math.max(leftResult.getHeight(), rightResult.getHeight())+1);
//        }
//
//        return new TreeResult(true, Math.max(leftResult.getHeight(), rightResult.getHeight())+1);
//    }

    private class TreeResult {
        private boolean isBalanced;
        private int height;

        public TreeResult(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }

        public boolean isBalanced() {
            return isBalanced;
        }

        public void setIsBalanced(boolean isBalanced) {
            this.isBalanced = isBalanced;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
