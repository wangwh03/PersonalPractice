package com.weihua.uber;

import com.weihua.careercup.chapter4.TreeNode;

// BST lowest
public class LowestCommonAncestor {

    public TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) {
            return null;
        }
        
        if (n2.getValue() < n1.getValue()) {
            TreeNode tmp = n1;
            n1 = n2;
            n2 = tmp;
        }
        
        TreeNode current = root;
        while (current != null && !(current.getValue() > n1.getValue() && current.getValue() < n2.getValue())) {
            if (current.getValue() > n2.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        
        return current;
        
    }
    
    
}
