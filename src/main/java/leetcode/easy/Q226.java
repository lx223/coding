package leetcode.easy;

import leetcode.CommonClasses;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/invert-binary-tree/">LeetCode Q226</>
 *
 * Thinking process:
 *
 * Recursion should always pop up first when dealing with tree. A level by level BFS should also do the job.
 */
public class Q226 extends CommonClasses {
    public TreeNode invertTree(TreeNode root) {
        return invertByIteration(root);
    }

    private TreeNode invertByIteration(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int lvlSize = queue.size();
            while (lvlSize-- > 0) {
                TreeNode node = queue.poll();
                TreeNode right = node.right;
                node.right = node.left;
                node.left = right;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }

    private TreeNode invertByRecursion(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
