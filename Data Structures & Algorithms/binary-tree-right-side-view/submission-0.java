class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // STEP 1: Initialize the Queue. 
        // We add the root even if it's null, as the loop handles nulls internally.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // rightSide will track the last non-null node we see in this specific level.
            TreeNode rightSide = null;
            // STEP 2: Capture the current level width.
            int qLen = q.size();

            // STEP 3: Process all nodes currently in the queue for this level.
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                
                // If the node is null, we just ignore it.
                if (node != null) {
                    // Because we iterate from left to right, the 'rightSide' variable 
                    // is constantly overwritten. The LAST node of the loop wins.
                    rightSide = node;
                    
                    // STEP 4: Add children to the queue for the NEXT level.
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            
            // STEP 5: If we found at least one valid node in this level, 
            // the 'rightSide' variable now holds the rightmost node.
            if (rightSide != null) {
                res.add(rightSide.val);
            }
        }
        return res;
    }
}