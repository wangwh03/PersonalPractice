package com.weihua.leetcode;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree tester = new SymmetricTree();
        System.out.println(tester.isSymmetric(null));
        TreeNode root = new TreeNode(1);
        System.out.println(tester.isSymmetric(root));

        TreeNode rootLeft = new TreeNode(2);
        root.left = rootLeft;
        System.out.println(tester.isSymmetric(root));

        TreeNode rootRight = new TreeNode(2);
        root.right = rootRight;
        System.out.println(tester.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // revert left half tree
        revertBinaryTree(root.left);
        // compare left right trees
        boolean compareResult = compareBinaryTree(root.left, root.right);
        // revert left back
        revertBinaryTree(root.left);

        return compareResult;
    }

    private void revertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        revertBinaryTree(root.left);
        revertBinaryTree(root.right);
    }

    private boolean compareBinaryTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val
                && compareBinaryTree(root1.left, root2.left)
                && compareBinaryTree(root1.right, root2.right);
    }


}
