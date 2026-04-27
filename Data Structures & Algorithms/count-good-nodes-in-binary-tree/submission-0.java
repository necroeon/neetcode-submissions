/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        // Start the DFS with the root's value as the initial maximum.
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int count = 0;
        // Step 1: Check if current node is "Good"
        if (node.val >= maxSoFar) {
            count = 1;
        }

        // Step 2: Update the maximum for the children
        int newMax = Math.max(maxSoFar, node.val);

        // Step 3: Recurse left and right and sum up the good nodes found
        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);

        return count;
    }
}
