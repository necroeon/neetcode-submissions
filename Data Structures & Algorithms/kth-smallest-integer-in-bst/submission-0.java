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
    public int kthSmallest(TreeNode root, int k) {
        // STEP 1: Use a stack to simulate the DFS "In-Order" traversal
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // STEP 2: Go as deep left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // STEP 3: Process the "Smallest" node currently available
            curr = stack.pop();
            k--; // We've visited one more node in sorted order
            
            // STEP 4: Check if this is the K-th node
            if (k == 0) {
                return curr.val;
            }

            // STEP 5: Move to the right subtree
            curr = curr.right;
        }

        return -1; // Should not be reached given valid k
    }
}
