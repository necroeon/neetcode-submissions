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
    public boolean isValidBST(TreeNode root) {
        // We use Long to handle the edge case of Integer.MIN_VALUE or MAX_VALUE 
        // being the actual value of a node in the tree.
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // STEP 1: An empty tree (or end of a branch) is technically valid.
        if (node == null) return true;

        // STEP 2: Check if current node violates the boundary.
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // STEP 3: Recurse with updated boundaries.
        // When going left, the current node becomes the NEW MAX.
        // When going right, the current node becomes the NEW MIN.
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}