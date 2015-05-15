package com.weihua.careercup.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public final class TreeUtil {

    public static void main(String[] args) {
        TreeNode treeHead = TreeUtil.create();
//        TreeUtil.printInOder(treeHead);
        TreeUtil.printTreeInLevel(treeHead);
    }
    
    public static TreeNode create() {
        int totalNodeNumber = 8;
        
        TreeNode[] nodes = new TreeNode[totalNodeNumber];
        for (int i = 0; i < totalNodeNumber; i++) {
            nodes[i] = new TreeNode(i);
        }
        
        nodes[0].setLeft(nodes[1]);
        nodes[0].setRight(nodes[2]);
 
        nodes[1].setLeft(nodes[3]);
        nodes[1].setRight(nodes[4]);
        
        nodes[2].setLeft(nodes[5]);
        nodes[2].setRight(nodes[6]);
        
        return nodes[0];
    }
    
    public static void printInOder(TreeNode head) {
        if (head == null) {
            return;
        }
        printInOder(head.getLeft());
        System.out.println(head.getValue());
        printInOder(head.getRight());
    }
    
    public static void printTreeInLevel(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(head);
        TreeNode dummyNode = new TreeNode(-1);
        queue.offer(dummyNode);
        
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.getValue() == dummyNode.getValue()) {
                System.out.println();
                queue.offer(new TreeNode(-1));
            } else {
                System.out.print(currentNode.getValue() + "\t");
                queue.offer(currentNode.getLeft());
                queue.offer(currentNode.getRight());
            }
        }
    }
}
