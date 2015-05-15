package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.weihua.careercup.chapter4.TreeNode;

public class SumPathAllResults {
    public static void main(String[] args) {
        SumPathAllResults test = new SumPathAllResults();
        System.out.println(test.hasPathSum(null, 0));
        System.out.println();
        
        TreeNode head = new TreeNode(1);
        System.out.println(test.hasPathSum(head, 0));
        System.out.println(test.hasPathSum(head, 1));
        System.out.println();

        TreeNode nl = new TreeNode(2);
        head.left = nl;
        System.out.println(test.hasPathSum(head, 3));
        System.out.println(test.hasPathSum(head, -3));
        System.out.println();
        
        TreeNode nr = new TreeNode(-1);
        head.right = nr;
        System.out.println(test.hasPathSum(head, 3));
        System.out.println(test.hasPathSum(head, 0));
        System.out.println(test.hasPathSum(head, 1));        
    }
    
    public List<List<Integer>> hasPathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) {
            return results;
        }
        
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(root.val);
            results.add(result);
            return results;
        }
        
        List<List<Integer>> leftResult = hasPathSum(root.left, sum - root.val);
        if (leftResult.size() != 0) {
            for (List<Integer> result : leftResult) {
                result.add(0, root.val);
            }
        }
        results.addAll(leftResult);
        
        List<List<Integer>> rightResult = hasPathSum(root.right, sum - root.val);
        if (rightResult.size() != 0) {
            for (List<Integer> result : rightResult) {
                result.add(0, root.val);
            }
        }
        
        results.addAll(rightResult);
        
        return results;
    }
    
}
