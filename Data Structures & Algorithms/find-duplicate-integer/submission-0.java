class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Finding the intersection point in the cycle
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];           // slow moves 1 step
            fast = nums[nums[fast]];     // fast moves 2 steps
        } while (slow != fast);

        // Phase 2: Finding the entrance to the cycle (the duplicate)
        fast = nums[0];                  // reset fast to start
        while (slow != fast) {
            slow = nums[slow];           // both move 1 step now
            fast = nums[fast];
        }

        return slow;                     // or return fast; they are the same
    }
}
