class Solution {
    public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0; //empty array check

    Set <Integer> set = new HashSet<>(); //creating new HashSet

    for (int num : nums) set.add(num); //converting the array into HashSet by copying array contents

    int longest = 0; //longest consecutive sequence
    int currentNum = 0; //working number
    int currentStreak = 0; //how many numbers in a row we have found so far

    for (int num : set){
        if (!set.contains(num-1)){ //a number is the start of a sequence if num-1 doesnt exist in the set
            currentNum = num;
            currentStreak = 1;
        }

        while (set.contains(currentNum + 1)){
            currentNum += 1;
            currentStreak += 1;
        }
        longest = Math.max(longest, currentStreak); //Compare the longest sequence I’ve seen so far with the current one, and keep the bigger value
    }

    return longest;

    }
}