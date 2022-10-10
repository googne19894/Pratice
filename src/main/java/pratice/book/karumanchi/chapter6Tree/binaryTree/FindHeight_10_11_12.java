package pratice.book.karumanchi.chapter6Tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class FindHeight_10_11_12 {
    private static int findHeightRecursive(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(findHeightRecursive(root.left), findHeightRecursive(root.right));
    }

    private static int findHeight(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int count = 1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            } else {
                if (!q.isEmpty()) {
                    count++;
                    q.offer(null);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(17);
        root.left.left.left = new TreeNode(13);
        root.left.left.left.left = new TreeNode(1);

        root.right = new TreeNode(11);
        root.right.left = new TreeNode(51);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);
        root.right.left.left.left = new TreeNode(11);

        System.out.println(findHeightRecursive(root));
        System.out.println(findHeight(root));
    }

}