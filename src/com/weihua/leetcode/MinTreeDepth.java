package com.weihua.leetcode;

import com.weihua.careercup.chapter4.TreeNode;

// find the min depth of a binary tree
// Recursive
//   1
// 2   3
// Min of Mindepth of left and Mindepth of right then + 1 
// return case: if left child == 0, mindepth left = 0
public class MinTreeDepth {
    public static void main(String[] args) {
        MinTreeDepth test = new MinTreeDepth();
        System.out.println(test.minDepth(null));
        
        TreeNode head = new TreeNode(1);
        System.out.println(test.minDepth(head));

        TreeNode nl = new TreeNode(2);
        head.left = nl;
        System.out.println(test.minDepth(head));
        
        TreeNode nr = new TreeNode(-1);
        head.right = nr;
        System.out.println(test.minDepth(head));
    }
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        return Math.min(minLeft, minRight) + 1;
    }
}
