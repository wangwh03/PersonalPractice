package com.weihua.leetcode;

import com.weihua.careercup.chapter4.TreeNode;

// Given a binary tree and a sum, determine if there is a root to leaf path with all nodes value adds up to sum

// 1
//2 3
// sub problem: left has sum-root.val, or right has sum-root.val
public class SumPath {
    public static void main(String[] args) {
        SumPath sumPath = new SumPath();
        System.out.println(sumPath.hasPathSum(null, 0));
        System.out.println(sumPath.hasPathSum(null, 1));
        System.out.println();
        
        TreeNode head = new TreeNode(1);
        System.out.println(sumPath.hasPathSum(head, 0));
        System.out.println(sumPath.hasPathSum(head, 1));
        System.out.println();

        TreeNode nl = new TreeNode(2);
        head.left = nl;
        System.out.println(sumPath.hasPathSum(head, 3));
        System.out.println(sumPath.hasPathSum(head, -3));
        System.out.println();
        
        TreeNode nr = new TreeNode(-1);
        head.right = nr;
        System.out.println(sumPath.hasPathSum(head, 3));
        System.out.println(sumPath.hasPathSum(head, 0));
        System.out.println(sumPath.hasPathSum(head, 1));
        
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum == 0) {
            return true;
        } else if (root == null && sum != 0) {
            return false;
        }
        
        boolean leftResult = hasPathSum(root.left, sum - root.val);
        if (leftResult) {
            return true;
        }
        
        boolean rightResult = hasPathSum(root.right, sum - root.val);
        return rightResult;
    }
    

}
