package com.weihua.leetcode;

import com.weihua.careercup.chapter4.TreeNode;

public class InvertBinaryTree {
    // Note: probably better to define the function signature with void rather than TreeNode like leetnode.
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        return root;
    }
}
