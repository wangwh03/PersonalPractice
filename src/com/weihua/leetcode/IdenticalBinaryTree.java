package com.weihua.leetcode;

public class IdenticalBinaryTree {
    
    public static void main(String[] args) {
        IdenticalBinaryTree tester = new IdenticalBinaryTree();
        System.out.println(tester.isSameTree(null, null));
        System.out.println(tester.isSameTree(null, new TreeNode(1)));
        System.out.println(tester.isSameTree(new TreeNode(1), null));
        System.out.println(tester.isSameTree(new TreeNode(1), new TreeNode(1)));
        System.out.println(tester.isSameTree(new TreeNode(1), new TreeNode(2)));
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        }
        
       if (p.val != q.val) {
           return false;
       } else {
           return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
       }
    }
}
