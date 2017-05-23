package com.weihua.leetcode;

import com.weihua.careercup.chapter4.TreeNode;

public class MaxLengthPathBinaryTree {

    public static void main(String[] args) {
        MaxLengthPathBinaryTree tester = new MaxLengthPathBinaryTree();
        System.out.println(tester.maxDepth(null));
        TreeNode root = new TreeNode(0);
        System.out.println(tester.maxDepth(root));
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        System.out.println(tester.maxDepth(root));
        root.right = right;
        System.out.println(tester.maxDepth(root));
        
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxLength = maxDepth(root.left);
        int rightMaxLength = maxDepth(root.right);
        return Math.max(leftMaxLength, rightMaxLength) + 1;
    }
    
}
