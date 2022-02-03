package com.striver.DSAExperience.T12Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(){}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode toTree(Integer[] ip) {
        if (ip.length == 0 || ip[0] == -1)
            return null;

        // Create the root of the tree
        TreeNode root = new TreeNode(ip[0]);
        // Push the root to the queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            TreeNode currNode = queue.poll();
            Integer currVal = ip[i++];

            // If the left child is not null
            if (currVal != null) {
                currNode.left = new TreeNode(currVal);
                queue.add(currNode.left);
            }

            // For the right child
            if (i >= ip.length) break;

            currVal = ip[i++];
            if (currVal != null) {
                currNode.right = new TreeNode(currVal);
                queue.add(currNode.right);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}